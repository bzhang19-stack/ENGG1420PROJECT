package UserFiles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CSVImport {

    public static ObservableList<Student> studentList = FXCollections.observableArrayList();
    public static ObservableList<Faculty> facultyList = FXCollections.observableArrayList();
    public static ObservableList<Admin> adminList = FXCollections.observableArrayList();


    public List<String[]> getCSVData(String fileName) {
        List<String[]> dataList = new ArrayList<>();

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("⚠️ File not found: " + fileName);
            return dataList; // Return empty list if file63 is missing
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) { //Reads file line by line
            String line; //Stores each line
            boolean firstLine = true; // Skip header... can be removed if header is not there

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the first line (header)
                }

                String[] data = line.split(","); // Splitting based on commas... each column becomes an entry in the array
                dataList.add(data); //Adds information to the data list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList; //Returns the dataList with all information from the file
    }
}
