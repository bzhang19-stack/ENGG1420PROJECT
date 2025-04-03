package FacultySceneControllers;

import UserFiles.Courses;
import com.example.project.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacultySubjectManagementViewCourseController implements Initializable {

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        Courses courses = Courses.getCourseBySubjectWithSection(SceneController.selection);

        String courseCode = courses.getCourseCode();
        String subjectCode = courses.getSubjectCode();
        int capacity = courses.getCapacity();
        String lectureTime = courses.getTime();
        String examInfo = courses.getFinalExamInfo();
        String location = courses.getFinalExamRoom();
        String instructorName = courses.getFinalExamInstructor();

        infoBox.setText("Course Code: "+courseCode+"\nSubject Code: "+subjectCode+"\nCapacity: "+capacity+"\nLecture Time: "+lectureTime+"\nFinal Exam Date/Time: "+examInfo+"\nFinal Exam Location: "+location+"\nInstructor: "+instructorName);
    }

    public void courseManagementBack(ActionEvent event) throws IOException {
        sceneController.showFacultySubjectManagement();
    }
    public void logout(ActionEvent event) throws IOException {
        sceneController.showDefaultMenu();
    }
}
