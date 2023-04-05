package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {
    @FXML
    private Label ruCafe;

    @FXML
    private ImageView basketMenuButton, coffeeMenuButton, donutMenuButton, ordersMenuButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void onBasketClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("order-basket-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onCoffeeClick(ActionEvent event) {

    }

    @FXML
    void onDonutClick(ActionEvent event) {

    }

    @FXML
    void onOrdersClick(ActionEvent event) {

    }

}