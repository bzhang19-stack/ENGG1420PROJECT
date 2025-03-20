package com.example.project;

import SceneControllers.FacultyDashboardController;
import SceneControllers.FacultyStudentManagementController;
import UserFiles.Admin;
import UserFiles.Faculty;
import UserFiles.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage primaryStage;
    private Student loggedInStudent;
    private Admin loggedInAdmin;
    private Faculty loggedInFaculty;

    public SceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // Show default menu
    public void showDefaultMenu() {
        Button loginButtonUser = new Button("User login");
        Button loginButtonAdmin = new Button("Admin login");

        loginButtonUser.setOnAction(e -> showLoginSceneUser());
        loginButtonAdmin.setOnAction(e -> showLoginSceneAdmin());

        StackPane defaultMenuLayout = new StackPane(loginButtonAdmin, loginButtonUser);
        Scene defaultMenuScene = new Scene(defaultMenuLayout, 500, 500);

        loginButtonAdmin.setTranslateX(0);
        loginButtonAdmin.setTranslateY(50);
        loginButtonUser.setTranslateX(0);
        loginButtonUser.setTranslateY(0);

        primaryStage.setTitle("Default Menu");
        primaryStage.setScene(defaultMenuScene);
        primaryStage.show();
    }

    // Show login scene for admin
    private void showLoginSceneAdmin() {
        LoginHandler loginHandler = new LoginHandler(this);
        loginHandler.showAdminLoginScene(primaryStage);
    }

    // Show login scene for user
    private void showLoginSceneUser() {
        LoginHandler loginHandler = new LoginHandler(this);
        loginHandler.showUserLoginScene(primaryStage);
    }

    // Show welcome screen for student users
    public void showStudentWelcomeScreen() {
        StudentDashboard studentDashboard = new StudentDashboard(this);
        studentDashboard.showStudentWelcomeScreen(primaryStage);
    }

    // Show welcome screen for faculty users
    public void showFacultyDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("facultyDashboard.fxml"));
        Parent root = loader.load();

        FacultyDashboardController facultyDashboardController = loader.getController();
        facultyDashboardController.setSceneController(this);
        facultyDashboardController.setFacultyMember(loggedInFaculty);
        facultyDashboardController.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

    }

    public void showFacultyStudentManagement() throws  IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("facultyStudentManagement.fxml"));
        Parent root = loader.load();

        FacultyStudentManagementController facultyStudentManagementController = loader.getController();
        facultyStudentManagementController.setSceneController(this);
        facultyStudentManagementController.setFacultyMember(loggedInFaculty);
        facultyStudentManagementController.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
    }

    // Show welcome screen for admin users
    public void showAdminWelcomeScreen() {
        AdminDashboard adminDashboard = new AdminDashboard(this);
        adminDashboard.showAdminWelcomeScreen(primaryStage);
    }

    // Show error/success alert
    public void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Setters for logged-in user
    public void setLoggedInStudent(Student student) {
        this.loggedInStudent = student;
    }

    public void setLoggedInAdmin(Admin admin) {
        this.loggedInAdmin = admin;
    }

    public void setLoggedInFaculty(Faculty faculty) {
        this.loggedInFaculty = faculty;
    }
}