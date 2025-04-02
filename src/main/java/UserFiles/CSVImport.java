package UserFiles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVImport {

    public static ObservableList<Student> importCSV() {
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        String filePath = "UMS_Data(Students ).csv"; // Ensure this file is in your project directory

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("CSV file not found!");
            return studentList;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLine = true; // To skip the header

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip the header
                    continue;
                }

                String[] data = line.split(","); // Split CSV values

                if (data.length == 6) { // Ensure correct format
                    Student student = new Student(
                            data[0], // Student ID
                            data[1], // Name
                            data[2], // Address
                            data[3], // Email
                            data[4], // Semester
                            data[5],
                            data[6],
                            data[7],
                            data[8] // Academic Level
                    );
                    studentList.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentList;
    }
}
