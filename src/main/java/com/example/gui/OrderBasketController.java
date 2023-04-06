package com.example.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderBasketController{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<String> ordersListView;
    private final String ITEM[] = {};
    private final ObservableList<String> ITEM_LIST = FXCollections.observableArrayList(ITEM);

    @FXML
    private Button placeOrderButton, removeItemButton, backButton;

    @FXML
    private TextField subtotalTF, taxTF, totalTF;

    @FXML
    void onPlaceOrderClicked(ActionEvent event) {

    }

    @FXML
    void onRemoveItemClicked(ActionEvent event) {
        String selectedItem = ordersListView.getSelectionModel().getSelectedItem();
        ITEM_LIST.remove(selectedItem);
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
