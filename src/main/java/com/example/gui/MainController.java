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
import model.Order;

import java.io.IOException;
import java.util.ArrayList;


public class MainController {
    @FXML
    private Label ruCafe;

    public static Order CURRENT_ORDER = new Order(1);
    public static ArrayList<Order> FINALIZED_ORDERS = new ArrayList<>();

    @FXML
    private Button basketMenuButton, coffeeMenuButton, donutMenuButton, ordersMenuButton;
    @FXML
    private ImageView donutImage, coffeeImage, basketImage, ordersImage;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void onBasketClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("order-basket-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onCoffeeClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("order-coffee-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onDonutClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("order-donut-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onOrdersClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("store-orders-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}