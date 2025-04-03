package com.example.project;

import UserFiles.CSVImport;
import UserFiles.Admin;
import UserFiles.Courses;
import UserFiles.Faculty;
import UserFiles.Student;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Student.initializeStudents(); // Ensure students are loaded
        Admin.initializeAdmin(); // Ensure admin is loaded
        Faculty.initializeFaculty(); // Ensure faculty is loaded
        Courses.initializeCourses(); // Ensure courses are loaded

        SceneController sceneController = new SceneController(primaryStage);
        sceneController.showDefaultMenu(); // Start with the default menu
    }

    public static void main(String[] args) {
        launch(args);
    }
}