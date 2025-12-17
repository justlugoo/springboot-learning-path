package org.example.springbootdemo;

public record Task(
        long id,
        String title,
        boolean completed
){}