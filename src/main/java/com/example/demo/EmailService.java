package com.example.demo;

import com.example.demo.aop.NotNull;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @NotNull
    public void send(String to, String text) {
        System.out.println("Sending email to: " + to + ", text: " + text);
    }

    public void sendWithoutCheck(String to, String text) {
        System.out.println("Sending email without check to: " + to + ", text: " + text);
    }
}