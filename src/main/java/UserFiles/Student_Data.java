package UserFiles;

import java.util.ArrayList;
import java.util.List;

public class Student_Data {
    private String studentId;
    private String name;
    private String email;
    private String address;
    private String telephone;
    private String academicLevel;
    private String currentSemester;

    private static List<Student_Data> allStudents = new ArrayList<>();

    public Student_Data(String studentId, String name, String email, String address, String telephone, String academicLevel, String currentSemester) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.academicLevel = academicLevel;
        this.currentSemester = currentSemester;
    }

    // Getter methods
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public String getCurrentSemester() {
        return currentSemester;
    }

    // Validate login by email and ID
    public boolean validateStudentLogin(String email, String studentId) {
        return this.email.equals(email) && this.studentId.equals(studentId);
    }

    // Load initial student data
    public static void initializeStudents() {
        allStudents.add(new Student_Data("S20250001", "Alice Smith", "123 Maple St.", "555-1234", "alice@example.edu", "Undergraduate", "Fall 2025"));
        allStudents.add(new Student_Data("S20250002", "Bob Johnson", "456 Oak St.", "555-5678", "bob@example.edu", "Graduate", "Fall 2025"));
        allStudents.add(new Student_Data("S20250003", "Carol Williams", "789 Pine St.", "555-9012", "carol@example.edu", "Graduate", "Fall 2025"));
        allStudents.add(new Student_Data("S20250004", "Lucka Racki", "1767 Jane St.", "439-9966", "lucka@example.edu", "Undergraduate", "Fall 2025"));
        allStudents.add(new Student_Data("S20250005", "David Lee", "90 Elm St.", "555-3456", "lee@example.edu", "Undergraduate", "Fall 2025"));
        allStudents.add(new Student_Data("S20250006", "Emily Brown", "111 Oak Ave.", "555-7890", "brown@example.edu", "Graduate", "Fall 2025"));
        allStudents.add(new Student_Data("S20250007", "George Smith", "222 Pine Rd.", "555-2345", "smith@example.edu", "Undergraduate", "Fall 2025"));
        allStudents.add(new Student_Data("S20250008", "Helen Jones", "333 Maple Dr.", "555-4567", "jones@example.edu", "Graduate", "Fall 2025"));
        allStudents.add(new Student_Data("S20250009", "Isaac Clark", "444 Cedar Ln.", "555-8901", "clark@example.edu", "Undergraduate", "Fall 2025"));
        allStudents.add(new Student_Data("S20250010", "Jennifer Davis", "555 Oakwood Pl", "555-3456", "davis@example.edu", "Graduate", "Fall 2025"));
        // Add more dummy data here
    }

    public static List<Student_Data> getAllStudents() {
        return allStudents;
    }

    //  New method to get student by email and ID
    public static Student_Data getStudentByEmailAndId(String email, String studentId) {
        for (Student_Data student : allStudents) {
            if (student.validateStudentLogin(email, studentId)) {
                return student;
            }
        }
        return null;
    }
}
