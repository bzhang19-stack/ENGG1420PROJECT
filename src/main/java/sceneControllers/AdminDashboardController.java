package sceneControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable{
    @FXML
    private ChoiceBox<String> dropdownMenu;
    @FXML
    private Label adminDashboardLabel;

    private final String[] options = {"Dashboard","Subject Management","Course Management","Student Management","Faculty Management","Even Management"}; // Options in choice box

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        dropdownMenu.getItems().addAll(options); // Populates choice box with options
    }

    public void getSelection(ActionEvent event){
        String selection = dropdownMenu.getValue();
        adminDashboardLabel.setText("You have selected: "+selection);
    }
}