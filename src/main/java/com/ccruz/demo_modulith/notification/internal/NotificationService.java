package com.ccruz.demo_modulith.notification.internal;

import org.springframework.stereotype.Service;

import com.ccruz.demo_modulith.publishing.Content;

@Service
public class NotificationService {

    private final SubscriberRepository subscribers;

    public NotificationService(SubscriberRepository repository) {
        this.subscribers = repository;
    }

    public void notifySubscribers(Content content) {
        subscribers.findAll().forEach(item ->
            System.out.printf("Notifying %s about: %s%n", item.email(), content.title())
        );
    }
}
