package UserFiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty extends User {
    private String degree;
    private String researchInterest;
    private String officeLocation;

    private static List<Faculty> allFaculty = new ArrayList<>();

    public Faculty(String id, String name, String email, String degree, String researchInterest, String officeLocation, String password, String[] courses) {
        super(name,id,email,password,courses);
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

    public static List<Faculty> getAllFaculty() {
        return CSVImport.facultyList;
    }


    // Load initial faculty data
    public static void initializeFaculty() {
        //allFaculty.add(new Faculty("F20250001", "Dr. Smith", "smith@example.edu", "PhD in AI", "Machine Learning", "Room 101", "password01", new String[]{"course1", "course2", "course3"}));
        //allFaculty.add(new Faculty("F20250002", "Dr. Johnson", "johnson@example.edu", "PhD in CS", "Data Science", "Room 102", "password02", new String[]{"course2", "course3"}));


        CSVImport importer = new CSVImport(); // Create an instance of CSVImport
        List<String[]> facultyData = importer.getCSVData("UMS_Data(Faculties ).csv"); // Call the method on the instance

        for(String[] data : facultyData){

            if(data.length==0) break; //Stops when there is no more data

            //Creating strings of data parsed from CSV file
            String id = data[0].trim();
            String name = data[1].trim();
            String degree = data[2].trim();
            String researchInterest = data[3].trim();
            String email = data[4].trim();
            String officeLocation = data[5].trim();
            String offeredCourses = data[6].trim();
            String password = data[7].trim();

            String[] courses = offeredCourses.split("/"); //Splits offeredCourses up into array of separate courses (delimited by '/')

            for(int i=0; i<courses.length; i++)
                courses[i] = courses[i].trim(); //Trims courses in array

            allFaculty.add(new Faculty(id,name,email,degree,researchInterest,officeLocation,password,courses)); //Adds faculty to arrayList
        }
        System.out.println("✅ Successfully loaded " + allFaculty.size() + " faculty from CSV.");
    }


    //  New method to get faculty by email and ID
    public static Faculty getFacultyByEmailAndPassword(String email, String password) {
        for (Faculty faculty : allFaculty) {
            if (faculty.validateLogin(email, password)) {
                return faculty;
            }
        }
        return null;
    }
}
