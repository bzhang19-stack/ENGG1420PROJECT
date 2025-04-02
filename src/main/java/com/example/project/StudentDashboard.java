package com.example.project;

import UserFiles.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class StudentDashboard {
    private SceneController sceneController;
    private Student loggedInStudent; // Store logged-in student

    public StudentDashboard(SceneController sceneController, Student loggedInStudent) {
        this.sceneController = sceneController;
        this.loggedInStudent = this.loggedInStudent; // Set the logged-in student
    }

    public void showStudentWelcomeScreen(Stage primaryStage) {

        Label welcomeLabel = new Label("Welcome to WebAdvisor Application!");
        Button logoutButton = new Button("Logout");

        MenuButton menuButton = new MenuButton("Select an Option");
        MenuItem item1 = new MenuItem("Account Data");
        MenuItem item2 = new MenuItem("Student Portal");

        item1.setOnAction(e -> showAccountView(primaryStage));
        item2.setOnAction(e -> showStudentPortal(primaryStage));

        menuButton.getItems().addAll(item1, item2);

        logoutButton.setOnAction(e -> sceneController.showDefaultMenu());

        VBox layout = new VBox(10, welcomeLabel, logoutButton, menuButton);
        layout.setAlignment(Pos.CENTER);
        Scene welcomeScene = new Scene(layout, 300, 200);
        primaryStage.setTitle("User Dashboard");
        primaryStage.setScene(welcomeScene);
    }

    private void showAccountView(Stage primaryStage) {

        Label titleLabel = new Label("Account Information");
        Label idLabel = new Label("Student ID: " + loggedInStudent.getID());
        Label nameLabel = new Label("Name: " + loggedInStudent.getName());
        Label addressLabel = new Label("Address: " + loggedInStudent.getAddress());
        Label telephoneLabel = new Label("Telephone: " + loggedInStudent.getTelephone());
        Label emailLabel = new Label("Email: " + loggedInStudent.getEmail());
        Label academicLevelLabel = new Label("Academic Level: " + loggedInStudent.getAcademicLevel());
        Label semesterLabel = new Label("Current Semester: " + loggedInStudent.getCurrentSemester());

        String coursesText = String.join(", ", loggedInStudent.getCourses());
        Label coursesLabel = new Label("Courses: " + coursesText);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> showStudentWelcomeScreen(primaryStage));

        VBox layout = new VBox(10, titleLabel, idLabel, nameLabel, addressLabel, telephoneLabel,
                emailLabel, academicLevelLabel, semesterLabel, coursesLabel, backButton);
        layout.setAlignment(Pos.CENTER);
        Scene accountScene = new Scene(layout, 400, 400);

        primaryStage.setTitle("Account View");
        primaryStage.setScene(accountScene);
    }




    private void showStudentPortal(Stage primaryStage) {
        // Student portal logic here
    }
}
