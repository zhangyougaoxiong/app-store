package com.example.appstore.service;

import com.example.appstore.annation.AppBean;

@AppBean(name = "myService")
public class MyService {

    public void printUsage() {
        System.out.println("myService print");
    }

    public void showUsage() {
        System.out.println("myService show");
    }
}
