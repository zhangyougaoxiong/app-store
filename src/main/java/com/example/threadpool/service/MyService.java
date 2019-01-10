package com.example.threadpool.service;

import com.example.threadpool.annation.AppBean;

@AppBean(name = "myService")
public class MyService {

    public void printUsage() {
        System.out.println("myService print");
    }
}
