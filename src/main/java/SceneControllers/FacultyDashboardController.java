package SceneControllers;

import UserFiles.FacultyData;
import com.example.project.SceneController;
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

    private SceneController sceneController;
    private Stage primaryStage;
    private FacultyData loggedInFaculty;

    private final String[] options = {"Dashboard","Subject Management","Course Management","Student Management","Faculty Management","Event Management"}; // Options in choice box;

    public void setPrimaryStage(Stage primaryStage){ this.primaryStage = primaryStage;} //Needed to link facultyDashboard stage to primaryStage in HelloApplication
    public void setSceneController(SceneController sceneController){ this.sceneController = sceneController;}
    public void setFacultyMember(FacultyData loggedInFaculty){ this.loggedInFaculty = loggedInFaculty;}


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        dropdownMenu.getItems().addAll(options); // Populates choice box with options
    }


    public void getSelection(ActionEvent event){
        String selection = dropdownMenu.getValue();
        menuLabel.setText("You have selected: "+selection);
    }
    public void logout(ActionEvent event) throws IOException {
        sceneController.showDefaultMenu();
    }
}