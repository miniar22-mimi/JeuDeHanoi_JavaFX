package com.example.demo2;

@FunctionalInterface
public interface StartHandler {
    void handle(String playerName, int numDisks);
}