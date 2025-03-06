package com.example.project;

// Imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class HelloApplication extends Application {
    // Stores the currently logged-in user
    private Student_Data loggedInStudent;
    private Admin_data loggedInAdmin;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Student_Data.initializeStudents(); // Ensure students are loaded
        Admin_data.initializeAdmin();
        showDefaultMenu(primaryStage);
    }

    // Default menu
    private void showDefaultMenu(Stage primaryStage) {
        Button loginButtonUser = new Button("User login");
        Button loginButtonAdmin = new Button("Admin login");

        loginButtonUser.setOnAction(e -> showLoginSceneUser(primaryStage));
        loginButtonAdmin.setOnAction(e -> showLoginSceneAdmin(primaryStage));

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

    // Login scene for admin
    private void showLoginSceneAdmin(Stage primaryStage) {
        TextField emailField = new TextField();
        emailField.setPromptText("Enter Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");

        // Validate login
        loginButton.setOnAction(e -> {
            String enteredAdminUser = emailField.getText();
            String enteredAdminPass = passwordField.getText();

            Admin_data admin = getAdminData(enteredAdminUser, enteredAdminPass);
            if (admin != null) {
                loggedInAdmin = admin; // Store the logged-in admin
                showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, Admin!");
                showAdminWelcomeScreen(primaryStage);
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Incorrect username or password.");
            }
        });

        backButton.setOnAction(e -> showDefaultMenu(primaryStage));

        // Align buttons side by side
        HBox buttonLayout = new HBox(10, loginButton, backButton);
        buttonLayout.setAlignment(Pos.CENTER);

        VBox loginLayout = new VBox(10, emailField, passwordField, buttonLayout);
        loginLayout.setStyle("-fx-padding: 20;");
        loginLayout.setAlignment(Pos.CENTER);

        Scene loginScene = new Scene(loginLayout, 300, 200);
        primaryStage.setTitle("Admin Login");
        primaryStage.setScene(loginScene);
    }

    // Login scene for user
    private void showLoginSceneUser(Stage primaryStage) {
        TextField emailField = new TextField();
        emailField.setPromptText("Enter Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Student ID");

        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");

        // Validate login
        loginButton.setOnAction(e -> {
            String enteredEmail = emailField.getText();
            String enteredPassword = passwordField.getText();

            Student_Data student = getStudentByEmailAndId(enteredEmail, enteredPassword);
            if (student != null) {
                loggedInStudent = student; // Store the logged-in user
                showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, " + student.getName() + "!");
                showWelcomeScreen(primaryStage);
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Incorrect email or password.");
            }
        });

        backButton.setOnAction(e -> showDefaultMenu(primaryStage));

        // Align buttons side by side
        HBox buttonLayout = new HBox(10, loginButton, backButton);
        buttonLayout.setAlignment(Pos.CENTER);

        VBox loginLayout = new VBox(10, emailField, passwordField, buttonLayout);
        loginLayout.setStyle("-fx-padding: 20;");
        loginLayout.setAlignment(Pos.CENTER);

        Scene loginScene = new Scene(loginLayout, 300, 200);
        primaryStage.setTitle("User Login");
        primaryStage.setScene(loginScene);
    }

    // Welcome screen for student users
    private void showWelcomeScreen(Stage primaryStage) {
        Label welcomeLabel = new Label("Welcome to WebAdvisor Application!");
        Button logoutButton = new Button("Logout");
        Button accountViewButton = new Button("Account Data");
        Button portalSceneButton = new Button("Student Portal");

        logoutButton.setOnAction(e -> {
            loggedInStudent = null; // Log out the user
            showDefaultMenu(primaryStage);
        });

        accountViewButton.setOnAction(e -> Accountview(primaryStage));
        portalSceneButton.setOnAction(e -> studentScene(primaryStage));

        VBox welcomeLayout = new VBox(10, welcomeLabel, logoutButton, accountViewButton, portalSceneButton);
        welcomeLayout.setStyle("-fx-padding: 20;");

        Scene welcomeScene = new Scene(welcomeLayout, 300, 200);
        primaryStage.setTitle("User Dashboard");
        primaryStage.setScene(welcomeScene);
    }

    // Welcome screen for admin users
    private void showAdminWelcomeScreen(Stage primaryStage) {
        Label welcomeLabel = new Label("Welcome, Admin!");
        Button logoutButton = new Button("Logout");
        Button manageStudentsButton = new Button("Manage Students");
        Button portalSceneButton = new Button("Admin Portal");

        logoutButton.setOnAction(e -> {
            loggedInAdmin = null; // Log out the admin
            showDefaultMenu(primaryStage);
        });

        manageStudentsButton.setOnAction(e -> System.out.println("Manage Students button clicked"));
        portalSceneButton.setOnAction(e -> System.out.println("Admin Portal button clicked"));

        VBox adminLayout = new VBox(10, welcomeLabel, logoutButton, manageStudentsButton, portalSceneButton);
        adminLayout.setStyle("-fx-padding: 20;");

        Scene adminScene = new Scene(adminLayout, 300, 200);
        primaryStage.setTitle("Admin Dashboard");
        primaryStage.setScene(adminScene);
    }

    // Student Portal
    private void studentScene(Stage primaryStage) {
        Label portalLabel = new Label("Student Portal");
        portalLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button backButton = new Button("Go back");
        backButton.setOnAction(e -> showWelcomeScreen(primaryStage));

        Button gradesButton = new Button("Grades\n Semester Grades");
        gradesButton.setMinSize(300, 100);
        gradesButton.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #d3d3d3; -fx-font-size: 14px; -fx-text-alignment: center;");
        gradesButton.setOnAction(e -> System.out.println("Grade button check"));

        VBox layout = new VBox(10, portalLabel, gradesButton);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20));

        StackPane root = new StackPane();
        root.getChildren().addAll(layout, backButton);
        StackPane.setAlignment(backButton, Pos.BOTTOM_LEFT);
        StackPane.setMargin(backButton, new Insets(10, 0, 10, 10));

        Scene portalScene = new Scene(root, 800, 500);
        primaryStage.setScene(portalScene);
        primaryStage.setTitle("Student Portal");
    }

    private void Accountview(Stage primaryStage) {
        if (loggedInStudent == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "No user is logged in.");
            return;
        }

        Label welcomeLabel = new Label("Your Account Details:");
        Button goBackButton = new Button("Go Back");
        goBackButton.setOnAction(e -> showWelcomeScreen(primaryStage));

        TextArea studentDataArea = new TextArea();
        studentDataArea.setEditable(false);
        studentDataArea.setPrefSize(400, 200);

        String studentData = String.format(
                "Student ID: %s\nName: %s\nAddress: %s\nTelephone: %s\nEmail: %s\nAcademic Level: %s\nCurrent Semester: %s",
                loggedInStudent.getStudentId(),
                loggedInStudent.getName(),
                loggedInStudent.getAddress(),
                loggedInStudent.getTelephone(),
                loggedInStudent.getEmail(),
                loggedInStudent.getAcademicLevel(),
                loggedInStudent.getCurrentSemester()
        );

        studentDataArea.setText(studentData);

        VBox accountViewLayout = new VBox(10, welcomeLabel, studentDataArea, goBackButton);
        accountViewLayout.setStyle("-fx-padding: 20;");

        Scene accountViewScene = new Scene(accountViewLayout, 500, 300);
        primaryStage.setTitle("Your Account");
        primaryStage.setScene(accountViewScene);
    }

    // Helper method to find a student by email and ID
    private Student_Data getStudentByEmailAndId(String email, String studentId) {
        for (Student_Data student : Student_Data.getAllStudents()) {
            if (student.validateLogin(email, studentId)) {
                return student;
            }
        }
        return null;
    }

    // Helper method to find admin
    private Admin_data getAdminData(String adminUser, String adminPass) {
        for (Admin_data admin : Admin_data.getAdmin()) {
            if (admin.validateLogin(adminUser, adminPass)) {
                return admin;
            }
        }
        return null;
    }

    // Alert box
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

