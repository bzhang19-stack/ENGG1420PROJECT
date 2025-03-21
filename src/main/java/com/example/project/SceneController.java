package com.example.project;

import FacultySceneControllers.*;
import UserFiles.Admin;
import UserFiles.Faculty;
import UserFiles.Student;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class SceneController {
    private Stage primaryStage;
    private Student loggedInStudent;
    private Admin loggedInAdmin;
    public static Faculty loggedInFaculty;

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
        facultyDashboardController.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Dashboard");
        primaryStage.setScene(scene);

    }

    /*public void showFacultySubjectManagement() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("facultySubjectManagement.fxml"));
        Parent root = loader.load();

        FacultySubjectManagementController facultySubjectManagementController = loader.getController();
        facultySubjectManagementController.setSceneController(this);
        facultySubjectManagementController.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Subject Management");
        primaryStage.setScene(scene);
    }*/

    public void showFacultyCourseManagement() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("facultyCourseManagement.fxml"));
        Parent root = loader.load();

        FacultyCourseManagementController facultyCourseManagementController = loader.getController();
        facultyCourseManagementController.setSceneController(this);
        facultyCourseManagementController.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Course Management");
        primaryStage.setScene(scene);
    }

    public void showFacultyStudentManagement() throws  IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("facultyStudentManagement.fxml"));
        Parent root = loader.load();

        FacultyStudentManagementController facultyStudentManagementController = loader.getController();
        facultyStudentManagementController.setSceneController(this);
        facultyStudentManagementController.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Student Management");
        primaryStage.setScene(scene);
    }

    public void showFacultyStudentManagementViewCourse(String selection) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("facultyStudentManagementViewCourse.fxml"));
        Parent root = loader.load();

        FacultyStudentManagementViewCourseController facultyStudentManagementViewCourseController = loader.getController();
        facultyStudentManagementViewCourseController.setSceneController(this);
        facultyStudentManagementViewCourseController.setPrimaryStage(primaryStage);
        facultyStudentManagementViewCourseController.setSelection(selection);

        Scene scene = new Scene(root);

        primaryStage.setTitle(selection+" View");
        primaryStage.setScene(scene);
    }

    /*public void showFacultyProfile() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("facultyProfile.fxml"));
        Parent root = loader.load();

        FacultyProfileController facultyProfileController = loader.load();
        facultyProfileController.setSceneController(this);
        facultyProfileController.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Profile View");
        primaryStage.setScene(scene);
    }*/

    public void showFacultyEventManagement() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("facultyEventManagement.fxml"));
        Parent root = loader.load();

        FacultyEventManagementController facultyEventManagementController = loader.getController();
        facultyEventManagementController.setSceneController(this);
        facultyEventManagementController.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Event Management");
        primaryStage.setScene(scene);
    }

    // Show welcome screen for admin users
    public void showAdminWelcomeScreen() {
        AdminDashboard adminDashboard = new AdminDashboard(this);
        adminDashboard.showAdminWelcomeScreen(primaryStage);
    }





    //WINDOW SHOWING ADD NEW STUDENT

    public void showAddStudentScene() {
        Stage addStudentStage = new Stage();
        addStudentStage.setTitle("Add New Student");

        // Input fields
        TextField idField = new TextField();
        idField.setPromptText("Enter Student ID");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter Student Name");

        TextField addressField = new TextField();
        addressField.setPromptText("Enter Address");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Enter Telephone");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter Email");

        TextField academicLevelField = new TextField();
        academicLevelField.setPromptText("Enter Academic Level");

        TextField semesterField = new TextField();
        semesterField.setPromptText("Enter Current Semester");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        TextField coursesField = new TextField();
        coursesField.setPromptText("Enter Courses (comma-separated)");

        // Buttons
        Button addButton = new Button("Add Student");
        Button backButton = new Button("Back");

        // Button Action
        addButton.setOnAction(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String academicLevel = academicLevelField.getText();
            String semester = semesterField.getText();
            String password = passwordField.getText();
            String[] courses = coursesField.getText().split(",");

            if (id.isEmpty() || name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please fill in all required fields.");
                return;
            }

            Student.addStudent(id, name, address, phone, email, academicLevel, semester, password, courses);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Student added successfully!");
            addStudentStage.close();
        });

        backButton.setOnAction(e -> addStudentStage.close());

        // Layout
        VBox layout = new VBox(10, idField, nameField, addressField, phoneField, emailField, academicLevelField, semesterField, passwordField, coursesField, addButton, backButton);
        layout.setAlignment(Pos.CENTER);

        Scene addStudentScene = new Scene(layout, 400, 500);
        addStudentStage.setScene(addStudentScene);
        addStudentStage.show();
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

    public void setLoggedInFaculty(Faculty faculty) { loggedInFaculty = faculty; }
}