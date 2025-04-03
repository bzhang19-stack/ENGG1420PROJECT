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

    public static ArrayList<Courses> courses = new ArrayList<>();

    public Courses(String subjectCode, String subjectName, String section, int capacity, String time, String finalExamInfo, String finalExamRoom, String finalExamInstructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.section = section;
        this.capacity = capacity;
        this.time = time;
        this.finalExamInfo = finalExamInfo;
        this.finalExamRoom = finalExamRoom;
        this.finalExamInstructor = finalExamInstructor;
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

    public static ArrayList<Courses> getAllCourses(){ return courses;}

    public static void initializeCourses() {

        /*
        courses.add(new Courses("MATH001", "Calculus I", "Section 1", 30, "Mon/Wed", "9-11 AM", "12/15/2025", "9:00", "Room 101", "Dr. Alan Turing"));
        courses.add(new Courses("ENG101", "Literature Basics", "Section 1", 25, "Tue/Thu", "10-12 PM", "12/16/2025", "10:00", "Room 102", "Prof. Emily Brontë"));
        courses.add(new Courses("ENG101", "Literature Basics", "Section 2", 25, "Mon/Wed", "10-12 PM", "12/16/2025", "10:00", "Room 102", "Prof. Emily Brontë"));
        courses.add(new Courses("CS201", "Introduction to Programming", "Section 1", 42, "Tue/Thu", "12-2 PM", "12/16/2025", "12:30", "Room 103", "Prof. Bahar Nozari"));
        courses.add(new Courses("CHEM200", "Introduction to Chemistry", "Section 1", 50, "Mon/Thu", "3-4 PM", "12/14/2025", "4:00", "Room 201", "Dr. Lucka Lucku"));
        courses.add(new Courses("CHEM200", "Introduction to Chemistry", "Section 2", 50, "Mon/Tue", "5-6 PM", "12/14/2025", "4:00", "Room 201", "Dr. Lucka Lucku"));
        courses.add(new Courses("CHEM200", "Introduction to Chemistry", "Section 3", 50, "Fri/Thu", "2-3 PM", "12/14/2025", "4:00", "Room 201", "Dr. Lucka Lucku"));
        courses.add(new Courses("ENG101", "Introduction to French", "Section 1", 25, "Tue/Thu", "4:30-5:30 PM", "12/13/2025", "10:00", "Room 202", "Dr. Lakyn Copeland"));
        courses.add(new Courses("ENG101", "Introduction to French", "Section 2", 25, "Tue/Thu", "5:30-6:30 PM", "12/13/2025", "10:00", "Room 202", "Dr. Lakyn Copeland"));
        courses.add(new Courses("ENGG402", "Water Resources", "Section 1", 50, "Mon/Fri", "9:00-10:30", "12/01/2025", "9:00", "Room 203", "Dr. Albozr Gharabaghi"));

        courses.add(new Courses("BIO300", "Biology", "N/A", 0, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"));
        courses.add(new Courses("HIST101", "History", "N/A", 0, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"));
        courses.add(new Courses("MUSIC102", "Music", "N/A", 0, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"));
        courses.add(new Courses("PSYCHO100", "Psychology", "N/A", 0, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"));
        */

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

            courses.add(new Courses(subjectCode,name,sectionNumber,num,lectureTime,finalExamInfo,finalExamRoom,finalExamInstructor));

        }
    }
}
