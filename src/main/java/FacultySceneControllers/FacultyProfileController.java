package FacultySceneControllers;

import com.example.project.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacultyProfileController implements Initializable{
    @FXML
    private ChoiceBox<String> dropdownMenu;
    @FXML
    private Button logoutButton;
    @FXML
    private Button passwordChangeButton;
    @FXML
    private TextArea infoBox;

    private SceneController sceneController;
    private Stage primaryStage;

    private final String[] options = {"Dashboard","Subject Management","Course Management","Student Management","Faculty Management","Event Management"}; // Options in choice box;

    public void setPrimaryStage(Stage primaryStage){ this.primaryStage = primaryStage;} //Needed to link facultyDashboard stage to primaryStage in HelloApplication
    public void setSceneController(SceneController sceneController){ this.sceneController = sceneController;}


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        dropdownMenu.getItems().addAll(options); // Populates choice box with options

        String name = SceneController.loggedInFaculty.getName();
        String id = SceneController.loggedInFaculty.getID();
        String email = SceneController.loggedInFaculty.getEmail();
        String degree = SceneController.loggedInFaculty.getDegree();
        String officeLocation = SceneController.loggedInFaculty.getOfficeLocation();
        String password = SceneController.loggedInFaculty.getPassword();

        infoBox.setText("Name: "+name+"\nID: "+id+"\nEmail: "+email+"\nDegree: "+degree+"\nOffice Location: "+officeLocation+"\nPassword (Sensitive): "+password);
    }

    public void getSelection(ActionEvent event) throws IOException {
        String selection = dropdownMenu.getValue();
        switch(selection){
            case "Dashboard": sceneController.showFacultyDashboard(); break;
            case "Subject Management": sceneController.showFacultySubjectManagement(); break;
            case "Student Management": sceneController.showFacultyStudentManagement(); break;
            case "Faculty Management": sceneController.showFacultyProfile(); break;
            case "Event Management": sceneController.showFacultyEventManagement(); break;
            case "Course Management": sceneController.showFacultyCourseManagement(); break;
        }
    }
    public void changePassword(ActionEvent event) throws IOException {
        sceneController.showFacultyPasswordChange();
    }
    public void logout(ActionEvent event) throws IOException {
        sceneController.showDefaultMenu();
    }
}