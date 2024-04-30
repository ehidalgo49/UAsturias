package org.challenge.notificationservice.usecases;

import org.challenge.notificationservice.Gateway;
import org.challenge.notificationservice.interfaces.NotificationService;
import org.challenge.notificationservice.RateLimiter;

import java.time.Duration;

public class NotificationServiceImpl implements NotificationService {
    private final Gateway gateway;
    private final RateLimiter rateLimiter;

    public NotificationServiceImpl(Gateway gateway) {
        this.gateway = gateway;
        this.rateLimiter = new RateLimiter();
    }

    @Override
    public void send(String type, String userId, String message) {
        int limit = 0;
        Duration period = Duration.ZERO;
        period = switch (type) {
            case "status" -> {
                limit = 2;
                yield Duration.ofMinutes(1);
            }
            case "news" -> {
                limit = 1;
                yield Duration.ofDays(1);
            }
            case "marketing" -> {
                limit = 3;
                yield Duration.ofHours(1);
            }
            default -> period;
        };

        if (rateLimiter.grantAccess(userId, type, limit, period)) {
            gateway.send(userId, message);
        } else {
            System.out.println("Rate limit exceeded for " + userId);
        }
    }
    }