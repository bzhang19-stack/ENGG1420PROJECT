package FacultySceneControllers;

import com.example.project.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FacultyStudentManagementViewCourseController {

    @FXML
    private Button backButton;
    @FXML
    private Button logoutButton;

    private SceneController sceneController;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage){ this.primaryStage = primaryStage;} //Needed to link facultyDashboard stage to primaryStage in HelloApplication
    public void setSceneController(SceneController sceneController){ this.sceneController = sceneController;}


    public void courseManagementBack(ActionEvent event) throws IOException {
        sceneController.showFacultyStudentManagement();
    }


    public void logout(ActionEvent event) throws IOException {
        sceneController.showDefaultMenu();
    }
}
