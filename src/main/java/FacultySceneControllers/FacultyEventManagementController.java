package FacultySceneControllers;

import UserFiles.Courses;
import UserFiles.Events;
import com.example.project.SceneController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class FacultyEventManagementController implements Initializable {
    @FXML
    private ChoiceBox<String> dropdownMenu;
    @FXML
    private Button logoutButton;
    @FXML
    private ListView<String> allEvents;

    private SceneController sceneController;
    private Stage primaryStage;

    private final String[] options = {"Dashboard","Subject Management","Course Management","Student Management","Faculty Management","Event Management"}; // Options in choice box;
    private String[] events = Events.getAllEventNames();

    public void setPrimaryStage(Stage primaryStage){ this.primaryStage = primaryStage;} //Needed to link facultyDashboard stage to primaryStage in HelloApplication
    public void setSceneController(SceneController sceneController){ this.sceneController = sceneController;}


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        dropdownMenu.getItems().addAll(options); // Populates choice box with options
        allEvents.getItems().addAll(events);

        allEvents.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                String selection = allEvents.getSelectionModel().getSelectedItem();
                try {
                    sceneController.showFacultyEventManagementViewEvent(selection);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
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
