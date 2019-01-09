package com.example.threadpool.service.impl;

import com.example.threadpool.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void printUsage() {
        System.out.println("userService print");
    }
}
