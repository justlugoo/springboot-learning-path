package org.example.springbootdemo;

public record TaskRequest(
        String title,
        Boolean completed) {
    public boolean isCompleted() {
        return completed != null && completed;
    }
}
