package com.example.project;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Student_Data.initializeStudents(); // Ensure students are loaded
        Admin_data.initializeAdmin(); // Ensure admin is loaded
        Faculty_Data.initializeFaculty(); // Ensure faculty is loaded

        SceneController sceneController = new SceneController(primaryStage);
        sceneController.showDefaultMenu(); // Start with the default menu
    }

    public static void main(String[] args) {
        launch(args);
    }
}