package org.challenge.notificationservice.interfaces;

public interface NotificationService {
    void send(String type, String userId, String message);

}
