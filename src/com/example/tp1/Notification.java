package com.example.tp1;

public interface Notification {
    void send(String recipient, String message);
    int getPriority();
    String getType();
}
