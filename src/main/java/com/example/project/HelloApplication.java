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

public class HelloApplication extends Application {
    // Stores the currently logged-in user
    private Student_Data loggedInStudent;
    private Admin_data loggedInAdmin;
    private Faculty_Data loggedInFaculty;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Student_Data.initializeStudents(); // Ensure students are loaded
        Admin_data.initializeAdmin(); //Ensure admin is loaded
        Faculty_Data.initializeFaculty(); //Ensures faculty are loaded
        showDefaultMenu(primaryStage);
    }

    // Default menu
    protected void showDefaultMenu(Stage primaryStage) { //Cannot be private as is will not be accessible in controllers (limits logout abilities)
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
        emailField.setPromptText("Enter Username/Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");

        // Validate login
        loginButton.setOnAction(e -> {
            String enteredEmail = emailField.getText();
            String enteredPassword = passwordField.getText();

            Student_Data student = getStudentByEmailAndId(enteredEmail, enteredPassword);
            Faculty_Data faculty = getFacultyByEmailAndID(enteredEmail, enteredPassword);
            if (student != null) { //Validates student user and sets appropriate scene
                loggedInStudent = student; // Store the logged-in user
                showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, " + student.getName() + "!");
                showStudentWelcomeScreen(primaryStage);
            }
            else if(faculty != null){ //Validates faculty user and sets appropriate scene
                loggedInFaculty = faculty;
                showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, " + faculty.getName() + "!");
                try { //Try/catch used for FXML loader withing showFacultyWelcomeScreen
                    showFacultyWelcomeScreen(primaryStage);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else {
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
    private void showStudentWelcomeScreen(Stage primaryStage) {
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

    //Welcome screen for faculty users
    private void showFacultyWelcomeScreen(Stage primaryStage) throws IOException {

        //Loads FXML file... cannot be done in one step as a NullPointerException is thrown upon logout attempt for some reason
        FXMLLoader loader = new FXMLLoader(getClass().getResource("facultyDashboard.fxml"));
        Parent root = loader.load();

        //Loads FacultyDashboardController
        FacultyDashboardController controller = loader.getController();

        //Passes primaryStage into controller and faculty member
        controller.setPrimaryStage(primaryStage);
        controller.setFacultyMember(loggedInFaculty);

        //Creates new scene and sets primaryStage with the scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    protected void facultyProfileView(Stage primaryStage, Faculty_Data loggedInFaculty) { //Cannot be private as it must be accessed by controller
        if (loggedInFaculty == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "No user is logged in.");
            return;
        }

        Label welcomeLabel = new Label("Your Account Details:");
        Button goBackButton = new Button("Go Back");
        goBackButton.setOnAction(e -> {
            try {
                showFacultyWelcomeScreen(primaryStage); //Try-catch used for fxml reasons
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        TextArea facultyDataArea = new TextArea();
        facultyDataArea.setEditable(false);
        facultyDataArea.setPrefSize(400, 200);

        String facultyData = String.format(
                "Faculty ID: %s\nName: %s\nDegree: %s\nResearch Interest: %s\nEmail: %s\nRoom: %s",
                loggedInFaculty.getFacultyID(),
                loggedInFaculty.getName(),
                loggedInFaculty.getDegree(),
                loggedInFaculty.getResearchInterest(),
                loggedInFaculty.getEmail(),
                loggedInFaculty.getOfficeLocation()
        );

        facultyDataArea.setText(facultyData);

        VBox accountViewLayout = new VBox(10, welcomeLabel, facultyDataArea, goBackButton);
        accountViewLayout.setStyle("-fx-padding: 20;");

        Scene accountViewScene = new Scene(accountViewLayout, 500, 300);
        primaryStage.setTitle("Your Account");
        primaryStage.setScene(accountViewScene);
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

        manageStudentsButton.setOnAction(e -> showManageStudentsScreen(primaryStage));
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
        backButton.setOnAction(e -> showStudentWelcomeScreen(primaryStage));

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
        goBackButton.setOnAction(e -> showStudentWelcomeScreen(primaryStage));

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

    // Manage students screen
    private void showManageStudentsScreen(Stage primaryStage) {
        Label titleLabel = new Label("Student List");
        TextArea studentTextArea = new TextArea();
        studentTextArea.setEditable(false);

        List<Student_Data> students = Student_Data.getAllStudents();
        StringBuilder studentData = new StringBuilder();
        for (Student_Data student : students) {
            studentData.append(String.format("ID: %s\nName: %s\nEmail: %s\nAddress: %s\nTelephone Number: %s\nAcademic Level: %s\nSemester: %s\n\n",
                    student.getStudentId(), student.getName(), student.getEmail(), student.getAddress(), student.getTelephone(), student.getAcademicLevel(), student.getCurrentSemester()));
        }
        studentTextArea.setText(studentData.toString());

        Button backButton = new Button("Go Back");
        backButton.setOnAction(e -> showAdminWelcomeScreen(primaryStage));

        VBox layout = new VBox(10, titleLabel, studentTextArea, backButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene studentScene = new Scene(layout, 500, 400);
        primaryStage.setTitle("Manage Students");
        primaryStage.setScene(studentScene);
    }


    // Helper method to find a student by email and ID
    private Student_Data getStudentByEmailAndId(String email, String studentId) {
        for (Student_Data student : Student_Data.getAllStudents()) {
            if (student.validateStudentLogin(email, studentId)) {
                return student;
            }
        }
        return null;
    }

    //Helper method to find faculty (keeps faculty member hidden)
    private Faculty_Data getFacultyByEmailAndID(String facultyUser, String facultyID){
        for(Faculty_Data faculty : Faculty_Data.getAllFaculty()) //Iterates through each faculty object
            if(faculty.validateFacultyLogin(facultyUser, facultyID)) //Validates faculty login
                return faculty;
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

