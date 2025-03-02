package com.example.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

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
        // Create buttons or input fields for login
        Button loginButton = new Button("Login");

        // Action for login button (here we just print a message for simplicity)
        loginButton.setOnAction(e -> System.out.println("Logged in"));

        // Set up the layout and scene for the login scene
        StackPane loginLayout = new StackPane();
        loginLayout.getChildren().add(loginButton);

        Scene loginScene = new Scene(loginLayout, 300, 200);

        primaryStage.setTitle("Login");
        primaryStage.setScene(loginScene);
    }


    public static void main(String[] args) {

        launch(args);
    }
}
