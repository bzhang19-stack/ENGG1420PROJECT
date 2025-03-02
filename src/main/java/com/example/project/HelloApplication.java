package com.example.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private final String validEmail = "user@example.com";
    private final String validPassword = "password123";

    @Override
    public void start(Stage primaryStage) {
        showDefaultMenu(primaryStage);


    }

    private void showDefaultMenu(Stage primaryStage) {
        // Create buttons
        Button loginButton = new Button("Go to Login");

        // Action for the login button
        loginButton.setOnAction(e -> showLoginScene(primaryStage));

        // Set up the layout and scene for the default menu
        StackPane defaultMenuLayout = new StackPane();
        defaultMenuLayout.getChildren().add(loginButton);

        Scene defaultMenuScene = new Scene(defaultMenuLayout, 300, 200);

        primaryStage.setTitle("Default Menu");
        primaryStage.setScene(defaultMenuScene);
        primaryStage.show();
    }

    private void showLoginScene(Stage primaryStage) {
        // Create text fields for username and password
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter Username");  // Placeholder text

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");  // Placeholder text

        // Create a login button
        Button loginButton = new Button("Login");

        // Action for login button
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.equals(validEmail) && password.equals(validPassword)) {
                // Success: Show a success alert
                displayAlert(Alert.AlertType.INFORMATION, "Login Success", "You have successfully logged in!");
            } else {
                // Failure: Show an error alert
                displayAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid email or password.");
            }
        });

        // Create a VBox layout to arrange the elements vertically
        VBox loginLayout = new VBox(10); // 10px spacing
        loginLayout.getChildren().addAll(usernameField, passwordField, loginButton);

        // Set up the scene with the VBox layout
        Scene loginScene = new Scene(loginLayout, 300, 200);

        primaryStage.setTitle("Login");
        primaryStage.setScene(loginScene);
    }

    private void displayAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }


        public static void main(String[] args) {

        launch(args);
    }
}
