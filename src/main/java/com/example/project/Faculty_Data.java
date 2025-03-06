package com.example.project;

import java.util.ArrayList;
import java.util.List;

public class Faculty_Data {
    private String facultyID;
    private String name;
    private String degree;
    private String researchInterest;
    private String email;
    private String officeLocation;

    //Final static list of faculty
    private static final List<Faculty_Data> facultyList = new ArrayList<>();

    //Constructor
    public Faculty_Data(String facultyId, String name, String degree, String researchInterest, String email, String officeLocation) {
        this.facultyID = facultyId;
        this.name = name;
        this.degree = degree;
        this.researchInterest = researchInterest;
        this.email = email;
        this.officeLocation = officeLocation;
    }

    //Get-attribute methods
    public String getFacultyID(){return facultyID;}
    public String getName(){return name;}
    public String getDegree(){return degree;}
    public String getResearchInterest(){return researchInterest;}
    public String getEmail(){return email;}
    public String getOfficeLocation(){return officeLocation;}
    public static List<Faculty_Data> getAllFaculty(){return facultyList;}

    public boolean validateFacultyLogin(String enteredEmail, String enteredPassword){
        return this.email.equalsIgnoreCase(enteredEmail) && this.facultyID.equals(enteredPassword);
    }

    public static void initializeFaculty(){
        if(!facultyList.isEmpty()) return; //Ensures no duplicate initialization

        facultyList.add(new Faculty_Data("F0001","Dr. Alan Turing","Ph.D.","Computational Theory","turing@university.edu","Room 201"));
        facultyList.add(new Faculty_Data("F0002","Prof. Emily Bronte","Master's","English Literature","bronte@university.edu","Room 202"));
        facultyList.add(new Faculty_Data("F0003","Dr. Grace Hopper","Ph.D.","Computer Programming","hopper@university.edu","Lab 203"));
        facultyList.add(new Faculty_Data("F0004","Dr. Lakyn Copeland","Master's","English Literature","copeland@university.edu","Room 201"));
        facultyList.add(new Faculty_Data("F0005","Albozr Gharabaghi","Ph.D.","Water and Soil","gharabaghi@university.edu","Lab 202"));
    }

}
