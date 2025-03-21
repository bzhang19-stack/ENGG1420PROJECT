package com.example.project;

import UserFiles.Courses;
import UserFiles.Student;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.util.List;
import javafx.scene.control.ComboBox;


public class AdminDashboard {
    private SceneController sceneController;

    public AdminDashboard(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public void showAdminWelcomeScreen(Stage primaryStage) {
        Label welcomeLabel = new Label("Welcome, Admin!");

        // Creating dropdown menus
        MenuButton studentManagementMenu = new MenuButton("Student Management");
        MenuItem manageStudentsMenuItem = new MenuItem("Manage Students");
        MenuItem studentDetailsMenuItem = new MenuItem("Student Details");
        MenuItem addNewStudentMenuItem = new MenuItem("Add New Student");
        studentManagementMenu.getItems().addAll(manageStudentsMenuItem, studentDetailsMenuItem,addNewStudentMenuItem );

        MenuButton facultyManagementMenu = new MenuButton("Faculty Management");
        MenuItem manageFacultyMenuItem = new MenuItem("Manage Faculty");
        facultyManagementMenu.getItems().addAll(manageFacultyMenuItem);

        MenuButton eventManagementMenu = new MenuButton("Event Management");
        MenuItem manageEventsMenuItem = new MenuItem("Manage Events");
        eventManagementMenu.getItems().addAll(manageEventsMenuItem);

        MenuButton courseManagementMenu = new MenuButton("Course Management");
        MenuItem courseDetailsMenuItem = new MenuItem("Course Details");
        MenuItem studentsEnrolledMenuItem = new MenuItem("Students Enrolled");
        courseManagementMenu.getItems().addAll(courseDetailsMenuItem, studentsEnrolledMenuItem);

        MenuButton optionsMenu = new MenuButton("Options");
        MenuItem logoutMenuItem = new MenuItem("Logout");
        optionsMenu.getItems().addAll(logoutMenuItem);

        // Setting actions
        logoutMenuItem.setOnAction(e -> sceneController.showDefaultMenu());
        manageStudentsMenuItem.setOnAction(e -> showManageStudentsScreen(primaryStage));
        studentDetailsMenuItem.setOnAction(e -> showStudentDetailsScreen(primaryStage));
        addNewStudentMenuItem.setOnAction(e -> showAddStudentScreen(primaryStage));//FIXED
        courseDetailsMenuItem.setOnAction(e -> showCourseDetailsScreen(primaryStage));
        studentsEnrolledMenuItem.setOnAction(e -> showStudentsEnrolledScreen(primaryStage));

        VBox layout = new VBox(10, welcomeLabel, studentManagementMenu, facultyManagementMenu, eventManagementMenu, courseManagementMenu, optionsMenu);
        layout.setAlignment(Pos.CENTER);
        Scene adminScene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Admin Dashboard");
        primaryStage.setScene(adminScene);
    }

    private void showStudentsEnrolledScreen(Stage primaryStage) {
    }

    private void showManageStudentsScreen(Stage primaryStage) {
        Label titleLabel = new Label("Manage Students");
        ComboBox<String> studentDropdown = new ComboBox<>();
        TextField nameField = new TextField();
        TextField addressField = new TextField();
        TextField telephoneField = new TextField();
        TextField academicLevelField = new TextField();
        TextField currentSemesterField = new TextField();
        Button updateButton = new Button("Update Student Info");

        List<Student> students = Student.getAllStudents();
        for (Student student : students) {
            studentDropdown.getItems().add(student.getName());
        }

        // When a student is selected, load their information into the fields
        studentDropdown.setOnAction(e -> {
            String selectedStudentName = studentDropdown.getValue();
            for (Student student : students) {
                if (student.getName().equals(selectedStudentName)) {
                    nameField.setText(student.getName());
                    addressField.setText(student.getAddress());
                    telephoneField.setText(student.getTelephone());
                    academicLevelField.setText(student.getAcademicLevel());
                    currentSemesterField.setText(student.getCurrentSemester());
                    break;
                }
            }
        });

        // When the Update button is clicked, update the student's information
        updateButton.setOnAction(e -> {
            String selectedStudentName = studentDropdown.getValue();
            for (Student student : students) {
                if (student.getName().equals(selectedStudentName)) {
                    student.setName(nameField.getText());
                    student.setAddress(addressField.getText());
                    student.setTelephone(telephoneField.getText());
                    student.setAcademicLevel(academicLevelField.getText());
                    student.setCurrentSemester(currentSemesterField.getText());

                    sceneController.showAlert(Alert.AlertType.INFORMATION, "Update Success", "Student information has been updated!");
                    break;
                }
            }
        });

        Button backButton = new Button("Go Back");
        backButton.setOnAction(e -> showAdminWelcomeScreen(primaryStage));

        VBox layout = new VBox(10, titleLabel, studentDropdown, new Label("Name:"), nameField, new Label("Address:"), addressField,
                new Label("Telephone:"), telephoneField, new Label("Academic Level:"), academicLevelField, new Label("Current Semester:"), currentSemesterField, updateButton, backButton);
        layout.setAlignment(Pos.CENTER);
        Scene manageStudentsScene = new Scene(layout, 400, 500);
        primaryStage.setTitle("Manage Students");
        primaryStage.setScene(manageStudentsScene);
    }



    private void showStudentDetailsScreen(Stage primaryStage) {
        Label titleLabel = new Label("Student Details");
        ComboBox<String> studentDropdown = new ComboBox<>();
        TextArea studentTextArea = new TextArea();
        studentTextArea.setEditable(false);

        List<Student> students = Student.getAllStudents();
        for (Student student : students) {
            studentDropdown.getItems().add(student.getName());
        }

        studentDropdown.setOnAction(e -> {
            String selectedStudent = studentDropdown.getValue();
            for (Student student : students) {
                if (selectedStudent.equals(student.getName())) {
                    studentTextArea.setText(String.format("ID: %s\nName: %s\nEmail: %s\nMajor: \nYear: ",
                            student.getID(), student.getName(), student.getEmail()/*,student.getMajor(), student.getYear()*/));
                    break;
                }
            }
        });

        //Add new student Dropdown







//MONKEY
        Button backButton = new Button("Go Back");
        backButton.setOnAction(e -> showAdminWelcomeScreen(primaryStage));

        VBox layout = new VBox(10, titleLabel, studentDropdown, studentTextArea, backButton);
        layout.setAlignment(Pos.CENTER);
        Scene studentScene = new Scene(layout, 600, 400);
        primaryStage.setTitle("Student Details");
        primaryStage.setScene(studentScene);
    }

    private void showCourseDetailsScreen(Stage primaryStage) {
        Label titleLabel = new Label("Course Details");
        ComboBox<String> courseDropdown = new ComboBox<>();
        TextArea courseTextArea = new TextArea();
        courseTextArea.setEditable(false);

        List<Courses> courses = Courses.getAllCourses();
        for (Courses course : courses) {
            courseDropdown.getItems().add(course.getSubjectName());
        }

        courseDropdown.setOnAction(e -> {
            String selectedCourse = courseDropdown.getValue();
            for (Courses course : courses) {
                if (selectedCourse.equals(course.getSubjectName())) {
                    courseTextArea.setText(String.format("Subject Code: %s\nName: %s\nSection: %s\nCapacity: %d\nSchedule: %s\nTime: %s\nFinal Exam Date: %s\nFinal Exam Time: %s\nFinal Exam Room: %s\nFinal Exam Instructor: %s",
                            course.getSubjectCode(), course.getSubjectName(), course.getSection(), course.getCapacity(),
                            course.getDays(), course.getTime(), course.getFinalExamDate(), course.getFinalExamTime(), course.getFinalExamRoom(),
                            course.getFinalExamInstructor()));
                    break;
                }
            }
        });



        Button backButton = new Button("Go Back");
        backButton.setOnAction(e -> showAdminWelcomeScreen(primaryStage));

        VBox layout = new VBox(10, titleLabel, courseDropdown, courseTextArea, backButton);
        layout.setAlignment(Pos.CENTER);
        Scene courseScene = new Scene(layout, 600, 400);
        primaryStage.setTitle("Course Details");
        primaryStage.setScene(courseScene);
    }

    private void showAddStudentScreen(Stage primaryStage) {
        Label titleLabel = new Label("Add New Student");
        ComboBox<String> studentDropdown = new ComboBox<>();


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

        Button addButton = new Button("Add Student");
        Button backButton = new Button("Back");

        // Add actions for buttons (this part can be modified to suit logic)
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
            updateStudentDropdown(studentDropdown); // Refresh dropdown after adding a student

            showAlert(Alert.AlertType.INFORMATION, "Success", "Student added successfully!");
            showAdminWelcomeScreen(primaryStage); // Navigate back to the dashboard

        });

        backButton.setOnAction(e -> showAdminWelcomeScreen(primaryStage)); //go back


        VBox layout = new VBox(10, titleLabel, idField, nameField, addressField, phoneField, emailField,
                academicLevelField, semesterField, passwordField, coursesField, addButton, backButton);
        layout.setAlignment(Pos.CENTER);

        Scene addStudentScene = new Scene(layout, 400, 500);
        primaryStage.setTitle("Add New Student");
        primaryStage.setScene(addStudentScene);
    }
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    private void updateStudentDropdown(ComboBox<String> studentDropdown) {
        if (studentDropdown == null) return; // Prevent null errors
        studentDropdown.getItems().clear();
        for (Student student : Student.getAllStudents()) {
            studentDropdown.getItems().add(student.getName());
        }
    }





}








/*
public class AdminDashboard {
    private SceneController sceneController;

    public AdminDashboard(SceneController sceneController) {
        this.sceneController = sceneController;
    }

    public void showAdminWelcomeScreen(Stage primaryStage) {
        Label welcomeLabel = new Label("Welcome, Admin!");
        Button logoutButton = new Button("Logout");
        Button manageStudentsButton = new Button("Manage Students");
        Button portalSceneButton = new Button("Manage Factulty");

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
        for (Student student : Student.getAllStudents()) {
            studentData.append(String.format("ID: %s\nName: %s\nEmail: %s\n\n",
                    student.getID(), student.getName(), student.getEmail()));
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
*/
