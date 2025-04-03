package FacultySceneControllers;

import UserFiles.Events;
import com.example.project.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacultyDashboardController implements Initializable{
    @FXML
    private ChoiceBox<String> dropdownMenu;
    @FXML
    private Button logoutButton;
    @FXML
    private TextArea eventsField;
    @FXML
    private TextArea coursesField;

    private SceneController sceneController;
    private Stage primaryStage;

    private final String[] options = {"Dashboard","Subject Management","Course Management","Student Management","Faculty Management","Event Management"}; // Options in choice box;

    public void setPrimaryStage(Stage primaryStage){ this.primaryStage = primaryStage;} //Needed to link facultyDashboard stage to primaryStage in HelloApplication
    public void setSceneController(SceneController sceneController){ this.sceneController = sceneController;}


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        dropdownMenu.getItems().addAll(options); // Populates choice box with options
        List<Events> eventsList = Events.getEvents(); //Creates list of events
        int ctr=1; //Counter for formatting purposes

        for(int i=0; i<SceneController.loggedInFaculty.getCourses().length; i++) //Iterates through every course of the faculty member
            coursesField.appendText("Course "+(i+1)+": "+SceneController.loggedInFaculty.getCourses()[i]+"\n"); //Adds courses to textArea

        for(Events events : eventsList) { //Iterates through each instance of Event
            eventsField.appendText("Event: " + ctr + ": " + events.getName() + "\n"); //Adds each event name to eventsField TextArea
            ctr++; //Counter for formatting purposes
        }
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
    public void logout(ActionEvent event) throws IOException {
        sceneController.showDefaultMenu();
    }
}