package com.vbc.servlet.management.service;

import com.vbc.servlet.management.dao.AdminDAO;
import com.vbc.servlet.management.model.Admin;

public class AdminService {
    private static final AdminDAO adminDao = new AdminDAO();

    public boolean registerAdmin(Admin admin) {
        return adminDao.registerAdmin(admin);
    }

    public Admin loginAdmin(String username, String password) {
        return adminDao.loginadmin(username,password);
    }
}
