package SceneControllers;

import UserFiles.Faculty;
import com.example.project.SceneController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FacultyStudentManagementController implements Initializable{
    @FXML
    private ChoiceBox<String> dropdownMenu;
    @FXML
    private Button logoutButton;
    @FXML
    private ListView<String> listView;

    private SceneController sceneController;
    private Stage primaryStage;
    private Faculty loggedInFaculty;
    private Parent root;
    private Scene scene;

    private final String[] options = {"Dashboard","Subject Management","Course Management","Student Management","Faculty Management","Event Management"}; // Options in choice box;
    private String[] courses = {"Course1", "Course2", "Course3"};

    public void setPrimaryStage(Stage primaryStage){ this.primaryStage = primaryStage;} //Needed to link facultyDashboard stage to primaryStage in HelloApplication
    public void setSceneController(SceneController sceneController){ this.sceneController = sceneController;}
    public void setFacultyMember(Faculty loggedInFaculty){ this.loggedInFaculty = loggedInFaculty;}


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        dropdownMenu.getItems().addAll(options); // Populates choice box with options
        listView.getItems().addAll(courses); // Populates list view with courses

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                String selection = listView.getSelectionModel().getSelectedItem();
                try {
                    viewCourse(selection);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public void getMenuSelection(ActionEvent event) throws IOException {
        String selection = dropdownMenu.getValue();
        switch (selection){
            case "Dashboard": sceneController.showFacultyDashboard();
            case "Student Management": sceneController.showFacultyStudentManagement();
        }
    }
    public void viewCourse(String selection) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("facultyStudentManagement.fxml"));
        Parent root = loader.load();





    }
    public void logout(ActionEvent event) throws IOException {
        sceneController.showDefaultMenu();
    }
}