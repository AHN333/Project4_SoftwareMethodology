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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderDonutController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView donutImage;
    @FXML
    private Button addToListButton, addToOrderButton, backButton;

    @FXML
    private ComboBox<?> donutTypeCombobox, quantityCombobox;

    @FXML
    private TextField donutSubtotalTF;

    @FXML
    private ListView<?> listViewCart, listViewFlavors;

    @FXML
    private Button removeFromListButton;

    @FXML
    void onAddToListClicked(ActionEvent event) {

    }

    @FXML
    void onAddToOrderClicked(ActionEvent event) {

    }

    @FXML
    void onRemoveFromListClicked(ActionEvent event) {

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
