package com.example.project;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class StudentDashboard {
    private SceneController sceneController;

    public StudentDashboard(SceneController sceneController) {
        this.sceneController = sceneController;
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
        // Account view logic here
    }

    private void showStudentPortal(Stage primaryStage) {
        // Student portal logic here
    }
}
