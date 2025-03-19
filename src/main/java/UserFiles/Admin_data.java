package UserFiles;

import java.util.ArrayList;
import java.util.List;

public class Admin_data {
    private String adminUser;
    private String adminPass;

    private static List<Admin_data> allAdmins = new ArrayList<>();

    public Admin_data(String adminUser, String adminPass) {
        this.adminUser = adminUser;
        this.adminPass = adminPass;
    }

    // Validate login
    public boolean validateLogin(String username, String password) {
        return this.adminUser.equals(username) && this.adminPass.equals(password);
    }

    // Load initial admin data
    public static void initializeAdmin() {
        allAdmins.add(new Admin_data("admin1", "password123"));
        allAdmins.add(new Admin_data("admin2", "adminpass"));
    }

    public static List<Admin_data> getAllAdmins() {
        return allAdmins;
    }

    // ✅ New method to get admin by username and password
    public static Admin_data getAdminData(String adminUser, String adminPass) {
        for (Admin_data admin : allAdmins) {
            if (admin.validateLogin(adminUser, adminPass)) {
                return admin;
            }
        }
        return null;
    }
}
