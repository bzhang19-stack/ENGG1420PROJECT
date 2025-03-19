package com.example.project;

import UserFiles.Student_Data;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class AdminDashboard {
    private SceneController sceneController;

    public AdminDashboard(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public void showAdminWelcomeScreen(Stage primaryStage) {
        Label welcomeLabel = new Label("Welcome, Admin!");
        Button logoutButton = new Button("Logout");
        Button manageStudentsButton = new Button("Manage Students");
        Button portalSceneButton = new Button("Admin Portal");

        logoutButton.setOnAction(e -> sceneController.showDefaultMenu());
        manageStudentsButton.setOnAction(e -> showManageStudentsScreen(primaryStage));

        VBox layout = new VBox(10, welcomeLabel, logoutButton, manageStudentsButton, portalSceneButton);
        layout.setAlignment(Pos.CENTER);
        Scene adminScene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Admin Dashboard");
        primaryStage.setScene(adminScene);
    }

    private void showManageStudentsScreen(Stage primaryStage) {
        Label titleLabel = new Label("Student List");
        TextArea studentTextArea = new TextArea();

        StringBuilder studentData = new StringBuilder();
        for (Student_Data student : Student_Data.getAllStudents()) {
            studentData.append(String.format("ID: %s\nName: %s\nEmail: %s\n\n",
                    student.getStudentId(), student.getName(), student.getEmail()));
        }
        studentTextArea.setText(studentData.toString());

        Button backButton = new Button("Go Back");
        backButton.setOnAction(e -> showAdminWelcomeScreen(primaryStage));

        VBox layout = new VBox(10, titleLabel, studentTextArea, backButton);
        layout.setAlignment(Pos.CENTER);
        Scene studentScene = new Scene(layout, 500, 400);
        primaryStage.setTitle("Manage Students");
        primaryStage.setScene(studentScene);
    }
}