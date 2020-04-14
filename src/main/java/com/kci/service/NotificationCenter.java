package com.kci.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationCenter {
    public void notify(String message) {
        System.out.println(message);
    }

    public void notifyf(String format, Object... args) {
        notify(String.format(format, args));
    }
}
