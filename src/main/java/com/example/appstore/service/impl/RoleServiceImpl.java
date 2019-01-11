package com.example.appstore.service.impl;

import com.example.appstore.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public void printUsage() {
        System.out.println("roleService print");
    }
}
