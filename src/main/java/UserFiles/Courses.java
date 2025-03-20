package UserFiles;

import java.util.ArrayList;

public class Courses {
    private String subjectCode;
    private String subjectName;
    private String section;
    private int capacity;
    private String days;
    private String time;
    private String finalExamDate;
    private String finalExamTime;
    private String finalExamRoom;
    private String finalExamInstructor;

    public Courses(String subjectCode, String subjectName, String section, int capacity, String days, String time,
                   String finalExamDate, String finalExamTime, String finalExamRoom, String finalExamInstructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.section = section;
        this.capacity = capacity;
        this.days = days;
        this.time = time;
        this.finalExamDate = finalExamDate;
        this.finalExamTime = finalExamTime;
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

    public String getDays() {
        return days;
    }

    public String getTime() {
        return time;
    }

    public String getFinalExamDate() {
        return finalExamDate;
    }

    public String getFinalExamTime() {
        return finalExamTime;
    }

    public String getFinalExamRoom() {
        return finalExamRoom;
    }

    public String getFinalExamInstructor() {
        return finalExamInstructor;
    }

    public static ArrayList<Courses> getAllCourses() {
        ArrayList<Courses> courses = new ArrayList<>();

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

        return courses;
    }
}
