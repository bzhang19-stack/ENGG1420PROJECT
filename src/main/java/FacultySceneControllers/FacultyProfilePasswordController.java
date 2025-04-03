package FacultySceneControllers;

import com.example.project.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacultyProfilePasswordController implements Initializable{
    @FXML
    private Button logoutButton;
    @FXML
    private Button confirm;
    @FXML
    private Button backButton;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;

    private SceneController sceneController;
    private Stage primaryStage;


    public void setPrimaryStage(Stage primaryStage){ this.primaryStage = primaryStage;} //Needed to link facultyDashboard stage to primaryStage in HelloApplication
    public void setSceneController(SceneController sceneController){ this.sceneController = sceneController;}


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
    }

    public void confirmChange(ActionEvent event) throws IOException {
        String pass1 = field1.getText();
        String pass2 = field2.getText();
        if(!pass1.equals(pass2)) {
            sceneController.showAlert(Alert.AlertType.INFORMATION, "Passwords Do Not Match", "Please Enter The Same Password");
            passwordLabel.setText("Passwords Must Match!");
        }
        else if(pass1.equals(SceneController.loggedInFaculty.getPassword()))
            sceneController.showAlert(Alert.AlertType.INFORMATION, "Passwords Is Already In Use", "Please Enter A New Password");
        else {
            SceneController.loggedInFaculty.setPassword(pass1);
            sceneController.showAlert(Alert.AlertType.INFORMATION, "Success", "Password Has Been Changed");
        }
    }
    public void logout(ActionEvent event) throws IOException {
        sceneController.showDefaultMenu();
    }
    public void back(ActionEvent event) throws IOException {
        sceneController.showFacultyProfile();
    }
}