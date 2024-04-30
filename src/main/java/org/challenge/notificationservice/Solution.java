package org.challenge.notificationservice;

import org.challenge.notificationservice.usecases.NotificationServiceImpl;


public class Solution {
    public void init() {
        Gateway gateway = new Gateway();
        NotificationServiceImpl service = new NotificationServiceImpl(gateway);
        service.send("news", "user", "news 1");
        service.send("news", "user", "news 2");
        service.send("news", "user", "news 3");
        service.send("news", "another user", "news 1");
        service.send("update", "user", "update 1");
    }
}