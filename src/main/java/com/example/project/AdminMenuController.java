package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable{
    @FXML
    private ChoiceBox<String> dropdownMenu;
    private final String[] options = {"Dashboard","Subject Management","Course Management","Student Management","Faculty Management","Even Management"}; // Options in choice box

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        dropdownMenu.getItems().addAll(options); // Populates choice box with options
    }
}