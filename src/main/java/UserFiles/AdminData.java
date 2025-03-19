package UserFiles;

import java.util.ArrayList;
import java.util.List;

public class AdminData {
    private String adminUser;
    private String adminPass;

    private static List<AdminData> allAdmins = new ArrayList<>();

    public AdminData(String adminUser, String adminPass) {
        this.adminUser = adminUser;
        this.adminPass = adminPass;
    }

    // Validate login
    public boolean validateLogin(String username, String password) {
        return this.adminUser.equals(username) && this.adminPass.equals(password);
    }

    // Load initial admin data
    public static void initializeAdmin() {
        allAdmins.add(new AdminData("admin1", "password123"));
        allAdmins.add(new AdminData("admin2", "adminpass"));
    }

    public static List<AdminData> getAllAdmins() {
        return allAdmins;
    }

    // ✅ New method to get admin by username and password
    public static AdminData getAdminData(String adminUser, String adminPass) {
        for (AdminData admin : allAdmins) {
            if (admin.validateLogin(adminUser, adminPass)) {
                return admin;
            }
        }
        return null;
    }
}
