package com.vbc.servlet.management.service;

import com.vbc.servlet.management.model.Admin;
import com.vbc.servlet.management.repository.AdminRepository;

public class AdminService {
    private static final AdminRepository adminRepository = new AdminRepository();

    public boolean registerAdmin(Admin admin) {
        return adminRepository.registerAdmin(admin);
    }

    public Admin loginAdmin(String username, String password) {
        return adminRepository.loginadmin(username,password);
    }
}
