package UserFiles;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String adminUser;
    private String adminPass;

    private static List<Admin> allAdmins = new ArrayList<>();

    public Admin(String adminUser, String adminPass) {
        this.adminUser = adminUser;
        this.adminPass = adminPass;
    }

    // Validate login
    public boolean validateLogin(String username, String password) {
        return this.adminUser.equals(username) && this.adminPass.equals(password);
    }

    // Load initial admin data
    public static void initializeAdmin() {
        allAdmins.add(new Admin("admin1", "password123"));
        allAdmins.add(new Admin("admin2", "adminpass"));
    }

    public static List<Admin> getAllAdmins() {
        return CSVImport.adminList;
    }

    // ✅ New method to get admin by username and password
    public static Admin getAdminData(String adminUser, String adminPass) {
        for (Admin admin : allAdmins) {
            if (admin.validateLogin(adminUser, adminPass)) {
                return admin;
            }
        }
        return null;
    }

    public void createFacultyProfile(){

    }
    public void editFacultyMember(){

    }
    public void deleteFacultyProfile(){

    }
    public void assignCourse(){

    }
}
