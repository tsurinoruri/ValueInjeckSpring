package com.example.demo;

import com.example.demo.aop.NotNull;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @NotNull
    public void updateName(Long userId, String name) {
        System.out.println("Updating user " + userId + " name to: " + name);
    }

    @NotNull
    public void updateEmail(Long userId, String email) {
        System.out.println("Updating user " + userId + " email to: " + email);
    }
}