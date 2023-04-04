module com.example.project4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
}