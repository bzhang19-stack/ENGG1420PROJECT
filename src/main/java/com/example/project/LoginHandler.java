package com.example.project;

import UserFiles.Admin;
import UserFiles.Faculty;
import UserFiles.Student;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import java.io.IOException;

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

            Admin admin = Admin.getAdminData(enteredAdminUser, enteredAdminPass);
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
        emailField.setPromptText("Enter Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");

        loginButton.setOnAction(e -> {
            String enteredEmail = emailField.getText();
            String enteredPassword = passwordField.getText();


            Student loggedInStudent = Student.getStudentByEmailAndPassword(enteredEmail, enteredPassword);

            if (loggedInStudent != null) {

                sceneController.setLoggedInStudent(loggedInStudent);


                StudentDashboard studentDashboard = new StudentDashboard(sceneController, loggedInStudent);
                studentDashboard.showStudentWelcomeScreen(primaryStage);

                sceneController.showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, " + loggedInStudent.getName() + "!");
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


    public void showFacultySceneLogin(Stage primaryStage) {
        TextField emailField = new TextField();
        emailField.setPromptText("Enter Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");

        loginButton.setOnAction(e -> {
            String enteredEmail = emailField.getText();
            String enteredPassword = passwordField.getText();

            Faculty faculty = Faculty.getFacultyByEmailAndPassword(enteredEmail, enteredPassword);

            if (faculty != null) {
                sceneController.setLoggedInFaculty(faculty);
                sceneController.showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, " + faculty.getName() + "!");
                try {
                    sceneController.showFacultyDashboard();
                } catch (IOException ex) {
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

        primaryStage.setTitle("Faculty Login");
        primaryStage.setScene(loginScene);


    }
}
