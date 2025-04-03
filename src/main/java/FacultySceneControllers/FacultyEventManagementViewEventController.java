package FacultySceneControllers;

import UserFiles.Events;
import com.example.project.SceneController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacultyEventManagementViewEventController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private Button logoutButton;
    @FXML
    private TextArea infoBox;

    private SceneController sceneController;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage){ this.primaryStage = primaryStage;} //Needed to link facultyDashboard stage to primaryStage in HelloApplication
    public void setSceneController(SceneController sceneController){ this.sceneController = sceneController;}

    Events thisEvent = Events.getEventByName(SceneController.selection);

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        String code = thisEvent.getCode();
        String name = thisEvent.getName();
        String description = thisEvent.getDescription();
        String location = thisEvent.getLocation();
        String dateAndTime = thisEvent.getDateAndTime();
        int capacity = thisEvent.getCapacity();

        infoBox.setText("Code: "+code+"\nName: "+name+"\nDescription: "+description+"\nLocation: "+location+"\nDate and Time: "+dateAndTime+"\nCapacity: "+capacity);
    }

    public void courseManagementBack(ActionEvent event) throws IOException {
        sceneController.showFacultyEventManagement();
    }


    public void logout(ActionEvent event) throws IOException {
        sceneController.showDefaultMenu();
    }
}
