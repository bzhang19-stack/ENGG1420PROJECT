package UserFiles;

import java.util.ArrayList;
import java.util.List;

public class Courses {
    private String subjectCode;
    private String subjectName;
    private String section;
    private int capacity;
    private String time;
    private String finalExamInfo;
    private String finalExamRoom;
    private String finalExamInstructor;
    private String courseCode;

    public static ArrayList<Courses> courses = new ArrayList<>();

    public Courses(String courseCode, String subjectCode, String subjectName, String section, int capacity, String time, String finalExamInfo, String finalExamRoom, String finalExamInstructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.section = section;
        this.capacity = capacity;
        this.time = time;
        this.finalExamInfo = finalExamInfo;
        this.finalExamRoom = finalExamRoom;
        this.finalExamInstructor = finalExamInstructor;
        this.courseCode = courseCode;
    }

    // Getter methods for each field
    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSection() {
        return section;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getTime() {
        return time;
    }

    public String getFinalExamInfo() {
        return finalExamInfo;
    }

    public String getFinalExamRoom() {
        return finalExamRoom;
    }

    public String getFinalExamInstructor() {
        return finalExamInstructor;
    }

    public String getCourseCode() { return  courseCode;}

    public static ArrayList<Courses> getAllCourses(){ return courses;}

    public static String[] getAllSubjects() {
        // Create an ArrayList to store the subject names with section numbers
        List<String> subjectNamesWithSections = new ArrayList<>();

        // Iterate over all courses and collect the subject names with section numbers
        for (Courses course : courses) {
            // Append the section number to the subject name
            String subjectWithSection = course.getSubjectName() + " - " + course.getSection();
            subjectNamesWithSections.add(subjectWithSection);
        }

        // Convert the list to an array and return it
        return subjectNamesWithSections.toArray(new String[0]);
    }



    public static void initializeCourses() {

        CSVImport importer = new CSVImport(); // Create an instance of CSVImport
        List<String[]> courseData = importer.getCSVData("UMS_Data(Courses).csv"); //Create array list of courses and their respective information

        for(String[] data : courseData){

            if(data.length==0) break; //Stops when there is no more data

            String courseCode = data[0].trim();
            String name = data[1].trim();
            String subjectCode = data[2].trim();
            String sectionNumber = data[3].trim();
            int num = Integer.parseInt(data[4].trim());
            String lectureTime = data[5].trim();
            String finalExamInfo = data[6].trim();
            String finalExamRoom = data[7].trim();
            String finalExamInstructor = data[8].trim();

            courses.add(new Courses(courseCode,subjectCode,name,sectionNumber,num,lectureTime,finalExamInfo,finalExamRoom,finalExamInstructor));

        }
    }
}
