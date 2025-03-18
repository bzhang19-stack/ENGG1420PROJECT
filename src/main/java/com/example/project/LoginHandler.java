package com.example.project;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class LoginHandler {
    private SceneController sceneController;

    public LoginHandler(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    // Admin login scene
    public void showAdminLoginScene(Stage primaryStage) {
        TextField emailField = new TextField();
        emailField.setPromptText("Enter Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");

        loginButton.setOnAction(e -> {
            String enteredAdminUser = emailField.getText();
            String enteredAdminPass = passwordField.getText();

            Admin_data admin = Admin_data.getAdminData(enteredAdminUser, enteredAdminPass);
            if (admin != null) {
                sceneController.setLoggedInAdmin(admin);
                sceneController.showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, Admin!");
                sceneController.showAdminWelcomeScreen();
            } else {
                sceneController.showAlert(Alert.AlertType.ERROR, "Login Failed", "Incorrect username or password.");
            }
        });

        backButton.setOnAction(e -> sceneController.showDefaultMenu());

        VBox layout = new VBox(10, emailField, passwordField, new HBox(10, loginButton, backButton));
        layout.setAlignment(Pos.CENTER);
        Scene loginScene = new Scene(layout, 300, 200);

        primaryStage.setTitle("Admin Login");
        primaryStage.setScene(loginScene);
    }

    // User login scene
    public void showUserLoginScene(Stage primaryStage) {
        TextField emailField = new TextField();
        emailField.setPromptText("Enter Username/Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");

        loginButton.setOnAction(e -> {
            String enteredEmail = emailField.getText();
            String enteredPassword = passwordField.getText();

            Student_Data student = Student_Data.getStudentByEmailAndId(enteredEmail, enteredPassword);
            Faculty_Data faculty = Faculty_Data.getFacultyByEmailAndID(enteredEmail, enteredPassword);

            if (student != null) {
                sceneController.setLoggedInStudent(student);
                sceneController.showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, " + student.getName() + "!");
                sceneController.showStudentWelcomeScreen();
            } else if (faculty != null) {
                sceneController.setLoggedInFaculty(faculty);
                sceneController.showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, " + faculty.getName() + "!");
                try {
                    sceneController.showFacultyWelcomeScreen();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                sceneController.showAlert(Alert.AlertType.ERROR, "Login Failed", "Incorrect email or password.");
            }
        });

        backButton.setOnAction(e -> sceneController.showDefaultMenu());

        VBox layout = new VBox(10, emailField, passwordField, new HBox(10, loginButton, backButton));
        layout.setAlignment(Pos.CENTER);
        Scene loginScene = new Scene(layout, 300, 200);

        primaryStage.setTitle("User Login");
        primaryStage.setScene(loginScene);


    }
}
