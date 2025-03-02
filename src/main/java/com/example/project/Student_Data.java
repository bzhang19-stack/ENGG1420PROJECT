import java.util.ArrayList;


public class Student_Data {
    private String studentId;
    private String name;
    private String address;
    private String telephone;
    private String email;
    private String academicLevel;
    private String currentSemester;

    // Constructor
    public Student_Data(String studentId, String name, String address, String telephone, String email, String academicLevel, String currentSemester) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.academicLevel = academicLevel;
        this.currentSemester = currentSemester;
    }

    // Getters for each field
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getTelephone() { return telephone; }
    public String getEmail() { return email; }
    public String getAcademicLevel() { return academicLevel; }
    public String getCurrentSemester() { return currentSemester; }

    // Overriding the toString() method to return a string representation of the student
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Address: " + address + ", Telephone: " + telephone + ", Email: " + email + ", Academic Level: " + academicLevel + ", Current Semester: " + currentSemester;
    }

    public static void main(String[] args) {
        ArrayList<Student_Data> students = new ArrayList<>();


        students.add(new Student_Data("S20250001", "Alice Smith", "123 Maple St.", "555-1234", "alice@example.edu", "Undergraduate", "Fall 2025"));
        students.add(new Student_Data("S20250002", "Bob Johnson", "456 Oak St.", "555-5678", "bob@example.edu", "Graduate", "Fall 2025"));
        students.add(new Student_Data("S20250003", "Carol Williams", "789 Pine St.", "555-9012", "carol@example.edu", "Graduate", "Fall 2025"));
        students.add(new Student_Data("S20250004", "Lucka Racki", "1767 Jane St.", "439-9966", "lucka@example.edu", "Undergraduate", "Fall 2025"));
        students.add(new Student_Data("S20250005", "David Lee", "90 Elm St.", "555-3456", "lee@example.edu", "Undergraduate", "Fall 2025"));
        students.add(new Student_Data("S20250006", "Emily Brown", "111 Oak Ave.", "555-7890", "brown@example.edu", "Graduate", "Fall 2025"));
        students.add(new Student_Data("S20250007", "George Smith", "222 Pine Rd.", "555-2345", "smith@example.edu", "Undergraduate", "Fall 2025"));
        students.add(new Student_Data("S20250008", "Helen Jones", "333 Maple Dr.", "555-4567", "jones@example.edu", "Graduate", "Fall 2025"));
        students.add(new Student_Data("S20250009", "Isaac Clark", "444 Cedar Ln.", "555-8901", "clark@example.edu", "Undergraduate", "Fall 2025"));
        students.add(new Student_Data("S20250010", "Jennifer Davis", "555 Oakwood Pl", "555-3456", "davis@example.edu", "Graduate", "Fall 2025"));

        for (Student_Data student : students) {
            System.out.println(student);
        }


    }
}
