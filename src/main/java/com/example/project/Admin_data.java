package com.example.project;

import java.util.ArrayList;
import java.util.List;

public class Admin_data {
    private String adminPass;
    private String adminUser;

    private static final List<Admin_data> adminList = new ArrayList<>();

    public Admin_data (String adminPass, String adminUser) {
        this.adminPass = adminPass;
        this.adminUser = adminUser;
    }

    public String getAdminPass () {
        return adminPass;
    }
    public String getAdminUser () {
        return adminUser;
    }

    public boolean validateLogin(String adminUser, String adminPass) {
        return this.adminPass.equals(adminPass) && this.adminUser.equals(adminUser);
    }

    public static void initializeAdmin() {
        if (!adminList.isEmpty()) return; // Avoid duplicate initialization

        adminList.add(new Admin_data("123", "admin"));
    }
    // Method to get admin
    public static List<Admin_data> getAdmin() {
        return adminList;
    }














}
