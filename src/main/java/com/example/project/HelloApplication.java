package com.example.project;
//imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javafx.geometry.Pos;
import javafx.geometry.Insets;


public class HelloApplication extends Application {
//taking in the arraylist from studentdata.java to parse the correct list of emails for authentication
    @Override
    public void start(Stage primaryStage) throws IOException {
        Student_Data.initializeStudents(); // Ensure students are loaded
        showDefaultMenu(primaryStage);
        //adminMenu(primaryStage);
    }
//Default menu
    private void showDefaultMenu(Stage primaryStage) {
        Button loginButtonUser = new Button("User login");
        Button loginButtonAdmin = new Button("Admin login");

        loginButtonUser.setOnAction(e -> showLoginScene(primaryStage));
        loginButtonAdmin.setOnAction(e -> showLoginScene(primaryStage));

        StackPane defaultMenuLayout = new StackPane(loginButtonAdmin, loginButtonUser);
        Scene defaultMenuScene = new Scene(defaultMenuLayout, 500, 500);

       loginButtonAdmin.setTranslateX(100);
       loginButtonAdmin.setTranslateY(50);

        loginButtonUser.setTranslateX(100);
        loginButtonUser.setTranslateY(0);


        primaryStage.setTitle("Default Menu");
        primaryStage.setScene(defaultMenuScene);
        primaryStage.show();
    }
//When clicking go to login
    private void showLoginScene(Stage primaryStage) {
        TextField emailField = new TextField();
        emailField.setPromptText("Enter Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password (Student ID for now)");

        Button loginButton = new Button("Login");

//validating the student login
        loginButton.setOnAction(e -> {
            String enteredEmail = emailField.getText();
            String enteredPassword = passwordField.getText();

            if (validateStudentLogin(enteredEmail, enteredPassword)) {
                showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, student!");
                showWelcomeScreen(primaryStage);
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Incorrect email or password.");
            }
        });
//creating the screen for the login
        VBox loginLayout = new VBox(10, emailField, passwordField, loginButton);
        loginLayout.setStyle("-fx-padding: 20;");

        Scene loginScene = new Scene(loginLayout, 300, 200);

        primaryStage.setTitle("Login");
        primaryStage.setScene(loginScene);
    }
//when logged on goes to here!
    private void showWelcomeScreen(Stage primaryStage) {
        Label welcomeLabel = new Label("Welcome to Webadvisor Application!");
        Button logoutButton = new Button("Logout");
        Button Adminaccountview = new Button("Accountdata");
        Button portalSceneButton = new Button("Student Portal");
        logoutButton.setOnAction(e -> showDefaultMenu(primaryStage));
        Adminaccountview.setOnAction(e -> Accountview(primaryStage));
        portalSceneButton.setOnAction(e -> studentScene(primaryStage));

        VBox welcomeLayout = new VBox(10, welcomeLabel, logoutButton, Adminaccountview, portalSceneButton);
        welcomeLayout.setStyle("-fx-padding: 20;");

        Scene welcomeScene = new Scene(welcomeLayout, 300, 200);
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(welcomeScene);
    }

    private void studentScene(Stage primaryStage) {
        // Create components
        Label portalLabel = new Label("Student Portal");
        Button backButton = new Button("Go back");

        // Set action for back button
        backButton.setOnAction(e -> showWelcomeScreen(primaryStage));

        // Create layout to hold the components
        VBox layout = new VBox(10, portalLabel);
        layout.setAlignment(Pos.TOP_CENTER);  // Keep the label at the top
        layout.setPadding(new Insets(20));

// Create StackPane as the root layout
        StackPane root = new StackPane();
        root.getChildren().addAll(layout, backButton);

// Position the go back at in bottomleft
        StackPane.setAlignment(backButton, Pos.BOTTOM_LEFT);
        StackPane.setMargin(backButton, new Insets(10, 0, 10, 10));  // Adds spacing


        Scene portalScene = new Scene(root, 800, 500);


        primaryStage.setScene(portalScene);
        primaryStage.setTitle("Student Portal");
    }



    private void Accountview(Stage primaryStage) {
        Label welcomeLabel = new Label("Here are the account details, admin!");
        Button goBackButton = new Button("Go Back");
        goBackButton.setOnAction(e -> showWelcomeScreen(primaryStage));

        // Create a TextArea to display student data
        TextArea studentDataArea = new TextArea();
        studentDataArea.setEditable(false);  // Make it read-only
        studentDataArea.setPrefSize(400, 300); // Set preferred size

        // Retrieve and format student data
        List<Student_Data> students = Student_Data.getAllStudents();
        StringBuilder studentData = new StringBuilder();

        studentData.append(String.format("%-15s %-20s %-30s%n", "Student ID", "Name", "Email"));
        studentData.append("------------------------------------------------------------\n");

        for (Student_Data student : students) {
            studentData.append(String.format("%-15s %-20s %-30s%n",
                    student.getStudentId(), student.getName(), student.getEmail()));
        }

        studentDataArea.setText(studentData.toString());

        VBox accountViewLayout = new VBox(10, welcomeLabel, studentDataArea, goBackButton);
        accountViewLayout.setStyle("-fx-padding: 20;");

        Scene accountViewScene = new Scene(accountViewLayout, 500, 400);
        primaryStage.setTitle("Student List");
        primaryStage.setScene(accountViewScene);
    }
    private void adminMenu(Stage primaryStage) throws IOException { //admin menu from fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminDashboard.fxml")));
        Scene menuScene = new Scene(root);
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }
//alert if the entered email is inocrrect
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Validate email and password (Student ID) against student list from Student_Data
    private boolean validateStudentLogin(String email, String studentId) {
        List<Student_Data> students = Student_Data.getAllStudents();
        for (Student_Data student : students) {
            if (student.validateLogin(email, studentId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
