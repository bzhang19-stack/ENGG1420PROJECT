package UserFiles;

import java.util.ArrayList;
import java.util.List;

public class FacultyData extends UserData{
    private String degree;
    private String researchInterest;
    private String officeLocation;

    private static List<FacultyData> allFaculty = new ArrayList<>();

    public FacultyData(String id, String name, String email, String degree, String researchInterest, String officeLocation, String password) {
        super(name,id,email,password);
        this.degree = degree;
        this.researchInterest = researchInterest;
        this.officeLocation = officeLocation;
    }

    // Getter methods
    public String getDegree() {
        return degree;
    }

    public String getResearchInterest() {
        return researchInterest;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public static List<FacultyData> getAllFaculty() {return allFaculty;}


    // Load initial faculty data
    public static void initializeFaculty() {
        allFaculty.add(new FacultyData("F20250001", "Dr. Smith", "smith@example.edu", "PhD in AI", "Machine Learning", "Room 101", "password01"));
        allFaculty.add(new FacultyData("F20250002", "Dr. Johnson", "johnson@example.edu", "PhD in CS", "Data Science", "Room 102", "password02"));
    }


    //  New method to get faculty by email and ID
    public static FacultyData getFacultyByEmailAndPassword(String email, String password) {
        for (FacultyData faculty : allFaculty) {
            if (faculty.validateLogin(email, password)) {
                return faculty;
            }
        }
        return null;
    }
}
