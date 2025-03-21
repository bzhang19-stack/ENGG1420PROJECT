module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.project to javafx.fxml;
    exports com.example.project;
    exports FacultySceneControllers;
    opens FacultySceneControllers to javafx.fxml;
    exports UserFiles;
    opens UserFiles to javafx.fxml;
}