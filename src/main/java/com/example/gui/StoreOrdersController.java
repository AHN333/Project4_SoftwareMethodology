package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class StoreOrdersController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button cancelOrderButton, exportOrderButton, backButton;

    @FXML
    private ComboBox<?> orderNumCombobox;
    @FXML
    private ListView<?> storeOrdersListView;

    @FXML
    private TextField totalTF;


    @FXML
    void onCancelOrderClicked(ActionEvent event) {

    }

    @FXML
    void onExportOrderClicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
    }
    @FXML
    void onBackButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
