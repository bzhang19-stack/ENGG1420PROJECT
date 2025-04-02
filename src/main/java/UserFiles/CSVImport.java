package UserFiles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.Arrays;

public class CSVImport {

    public static ObservableList<Student> studentList = FXCollections.observableArrayList();
    public static ObservableList<Faculty> facultyList = FXCollections.observableArrayList();
    public static ObservableList<Admin> adminList = FXCollections.observableArrayList();

    public static void importCSV() {
        String filePath = "UMS_Data(Students ).csv"; // Ensure the file is in the correct directory

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("CSV file not found!");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLine = true; // Skip header

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip the header
                    continue;
                }

                String[] data = line.split(","); // Split CSV values
                if (data.length < 6) continue; // Ensure minimum fields exist

                String type = data[0].trim(); // Student, Faculty, or Admin

                if (type.equalsIgnoreCase("Student") && data.length >= 9) {
                    // Student data
                    String id = data[1].trim();
                    String name = data[2].trim();
                    String address = data[3].trim();
                    String telephone = data[4].trim();
                    String email = data[5].trim();
                    String academicLevel = data[6].trim();
                    String currentSemester = data[7].trim();
                    String password = data[8].trim();
                    String[] courses = data.length > 9 ? data[9].split(";") : new String[]{};

                    Student student = new Student(id, name, address, telephone, email, academicLevel, currentSemester, password, courses);
                    studentList.add(student);
                }
                else if (type.equalsIgnoreCase("Faculty") && data.length >= 9) {
                    // Faculty data
                    String id = data[1].trim();
                    String name = data[2].trim();
                    String email = data[3].trim();
                    String degree = data[4].trim();
                    String researchInterest = data[5].trim();
                    String officeLocation = data[6].trim();
                    String password = data[7].trim();
                    String[] courses = data.length > 8 ? data[8].split(";") : new String[]{};

                    Faculty faculty = new Faculty(id, name, email, degree, researchInterest, officeLocation, password, courses);
                    facultyList.add(faculty);
                }
                else if (type.equalsIgnoreCase("Admin") && data.length >= 3) {
                    // Admin data
                    String adminUser = data[1].trim();
                    String adminPass = data[2].trim();

                    Admin admin = new Admin(adminUser, adminPass);
                    adminList.add(admin);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
