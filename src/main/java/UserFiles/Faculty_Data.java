package UserFiles;

import java.util.ArrayList;
import java.util.List;

public class Faculty_Data {
    private String facultyID;
    private String name;
    private String email;
    private String degree;
    private String researchInterest;
    private String officeLocation;

    private static List<Faculty_Data> allFaculty = new ArrayList<>();

    public Faculty_Data(String facultyID, String name, String email, String degree, String researchInterest, String officeLocation) {
        this.facultyID = facultyID;
        this.name = name;
        this.email = email;
        this.degree = degree;
        this.researchInterest = researchInterest;
        this.officeLocation = officeLocation;
    }

    // Getter methods
    public String getFacultyID() {
        return facultyID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDegree() {
        return degree;
    }

    public String getResearchInterest() {
        return researchInterest;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    // Validate faculty login
    public boolean validateFacultyLogin(String email, String facultyID) {
        return this.email.equals(email) && this.facultyID.equals(facultyID);
    }

    // Load initial faculty data
    public static void initializeFaculty() {
        allFaculty.add(new Faculty_Data("F20250001", "Dr. Smith", "smith@example.edu", "PhD in AI", "Machine Learning", "Room 101"));
        allFaculty.add(new Faculty_Data("F20250002", "Dr. Johnson", "johnson@example.edu", "PhD in CS", "Data Science", "Room 102"));
    }

    public static List<Faculty_Data> getAllFaculty() {
        return allFaculty;
    }

    //  New method to get faculty by email and ID
    public static Faculty_Data getFacultyByEmailAndID(String email, String facultyID) {
        for (Faculty_Data faculty : allFaculty) {
            if (faculty.validateFacultyLogin(email, facultyID)) {
                return faculty;
            }
        }
        return null;
    }
}
