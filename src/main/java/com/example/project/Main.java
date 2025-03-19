package com.example.project;

import UserFiles.AdminData;
import UserFiles.FacultyData;
import UserFiles.StudentData;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        StudentData.initializeStudents(); // Ensure students are loaded
        AdminData.initializeAdmin(); // Ensure admin is loaded
        FacultyData.initializeFaculty(); // Ensure faculty is loaded

        SceneController sceneController = new SceneController(primaryStage);
        sceneController.showDefaultMenu(); // Start with the default menu
    }

    public static void main(String[] args) {
        launch(args);
    }
}