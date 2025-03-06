package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacultyDashboardController implements Initializable{
    @FXML
    private ChoiceBox<String> dropdownMenu;
    @FXML
    private Label menuLabel;
    @FXML
    private Button logoutButton;

    private final String[] options = {"Dashboard","Subject Management","Course Management","Student Management","Faculty Management","Event Management"}; // Options in choice box

    private Stage primaryStage;
    private Faculty_Data loggedInFaculty;

    private final HelloApplication helloApplication = new HelloApplication();

    public void setPrimaryStage(Stage primaryStage){ this.primaryStage = primaryStage;} //Needed to link facultyDashboard stage to primaryStage in HelloApplication

    public void setFacultyMember(Faculty_Data loggedInFaculty){ this.loggedInFaculty = loggedInFaculty;}


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        dropdownMenu.getItems().addAll(options); // Populates choice box with options
    }

    public void getSelection(ActionEvent event){
        String selection = dropdownMenu.getValue();
        menuLabel.setText("You have selected: "+selection);
        if(selection.equals(options[4]))
            helloApplication.facultyProfileView(primaryStage, loggedInFaculty);

    }
    public void logout(ActionEvent event) throws IOException {
        helloApplication.showDefaultMenu(primaryStage);
    }
}