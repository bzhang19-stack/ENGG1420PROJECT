package UserFiles;

import java.util.ArrayList;
import java.util.List;


public class Student extends User {
    private String address;
    private String telephone;
    private String academicLevel;
    private String currentSemester;

    private static List<Student> allStudents = new ArrayList<>();

    public Student(String id, String name, String address, String telephone, String email, String academicLevel, String currentSemester, String password, String[] courses) {
        super(name, id, email, password, courses);
        this.address = address;
        this.telephone = telephone;
        this.academicLevel = academicLevel;
        this.currentSemester = currentSemester;

    }

    // Getter methodsd
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

    public static List<Student> getAllStudents() {
        return CSVImport.studentList;
    }

    // Setter methods to update the student information
    public void setName(String name) {
        super.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public void setCurrentSemester(String currentSemester) {
        this.currentSemester = currentSemester;
    }

    // Load initial student data
    public static void initializeStudents() {
//        allStudents.add(new Student("S20250001", "Alice Smith", "123 Maple St.", "555-1234", "alice@example.edu", "Undergraduate", "Fall 2025", "default123", new String[]{"course1", "course2", "course3"}));
//        allStudents.add(new Student("S20250002", "Bob Johnson", "456 Oak St.", "555-5678", "bob@example.edu", "Graduate", "Fall 2025", "default123", new String[]{"course1", "course2"}));
//        allStudents.add(new Student("S20250003", "Carol Williams", "789 Pine St.", "555-9012", "carol@example.edu", "Graduate", "Fall 2025", "default123", new String[]{"course1", "course2"}));
//        allStudents.add(new Student("S20250004", "Lucka Racki", "1767 Jane St.", "439-9966", "lucka@example.edu", "Undergraduate", "Fall 2025", "default123", new String[]{"course1", "course2"}));
//        allStudents.add(new Student("S20250005", "David Lee", "90 Elm St.", "555-3456", "lee@example.edu", "Undergraduate", "Fall 2025", "default123", new String[]{"course1", "course2"}));
//        allStudents.add(new Student("S20250006", "Emily Brown", "111 Oak Ave.", "555-7890", "brown@example.edu", "Graduate", "Fall 2025", "default123", new String[]{"course1", "course2"}));
//        allStudents.add(new Student("S20250007", "George Smith", "222 Pine Rd.", "555-2345", "smith@example.edu", "Undergraduate", "Fall 2025", "default123", new String[]{"course1", "course2"}));
//        allStudents.add(new Student("S20250008", "Helen Jones", "333 Maple Dr.", "555-4567", "jones@example.edu", "Graduate", "Fall 2025", "default123", new String[]{"course1", "course2"}));
//        allStudents.add(new Student("S20250009", "Isaac Clark", "444 Cedar Ln.", "555-8901", "clark@example.edu", "Undergraduate", "Fall 2025", "default123", new String[]{"course1", "course2"}));
//        allStudents.add(new Student("S20250010", "Jennifer Davis", "555 Oakwood Pl", "555-3456", "davis@example.edu", "Graduate", "Fall 2025", "default123", new String[]{"course1", "course2"}));
//        // Add more dummy data here
        CSVImport importer = new CSVImport(); // Create an instance of CSVImport
        List<String[]> studentsData = importer.getCSVData("UMS_Data(Students).csv"); // Call the method on the instance

        if (studentsData.isEmpty()) {
            System.out.println("⚠️ No student data found in CSV.");
            return;
        }

        for (String[] data : studentsData) {
            if (data.length < 9) continue; // Skip invalid rows

            String type = data[0].trim(); // First column should be "Student"
            if (!type.equalsIgnoreCase("Student")) continue; // Ignore non-student rows

            String id = data[1].trim();
            String name = data[2].trim();
            String address = data[3].trim();
            String telephone = data[4].trim();
            String email = data[5].trim();
            String academicLevel = data[6].trim();
            String currentSemester = data[7].trim();
            String password = data[8].trim();
            String[] courses = data.length > 9 ? data[9].split(";") : new String[]{}; // Handle courses

            Student student = new Student(id, name, address, telephone, email, academicLevel, currentSemester, password, courses);
            allStudents.add(student);
        }

        System.out.println("✅ Successfully loaded " + allStudents.size() + " students from CSV.");

    }

    //METHOD FOR ADMIN TO ADD STUDENTS
    public static void addStudent(String id, String name, String address, String telephone, String email, String academicLevel, String currentSemester, String password, String[] courses) {
        Student newStudent = new Student(id, name, address, telephone, email, academicLevel, currentSemester, password, courses);
        allStudents.add(newStudent);
    }




    //  New method to get student by email and ID
    public static Student getStudentByEmailAndPassword(String email, String password) {
        for (Student student : allStudents) {
            if (student.validateLogin(email, password)) {
                return student;
            }
        }
        return null;
    }
}