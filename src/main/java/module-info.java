/**
 * Module-info for project 4. A GUI for our a rutgers cafe.
 */
module com.example.project4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group9.cafe to javafx.fxml;
    exports com.group9.cafe;
    exports com.group9.model;
}