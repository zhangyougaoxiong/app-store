package com.example.appstore.service.impl;

import com.example.appstore.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUsage() {
        System.out.println("userService print");
    }
}
