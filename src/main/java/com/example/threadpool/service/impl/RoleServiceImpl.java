package com.example.threadpool.service.impl;

import com.example.threadpool.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public void printUsage() {
        System.out.println("roleService print");
    }
}
