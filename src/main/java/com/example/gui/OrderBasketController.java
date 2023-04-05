package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderBasketController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<?> ordersListView;

    @FXML
    private Button placeOrderButton, removeItemButton, backButton;

    @FXML
    private TextField subtotalTF, taxTF, totalTF;

    @FXML
    void onPlaceOrderClicked(ActionEvent event) {

    }

    @FXML
    void onRemoveItemClicked(ActionEvent event) {

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
