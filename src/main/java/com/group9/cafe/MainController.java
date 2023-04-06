package com.group9.cafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.group9.model.Order;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Main controller for the main menu GUI.
 * @author William Barrese, Andy Nguyen
 */
public class MainController {
    /**
     * JavaFX Label for the title.
     */
    @FXML
    private Label ruCafe;
    /**
     * Order object for the current order.
     */
    public static Order CURRENT_ORDER = new Order(1);
    /**
     * ArrayList of finalized orders.
     */
    public static ArrayList<Order> FINALIZED_ORDERS = new ArrayList<>();
    /**
     * JavaFX buttons that navigate to different ordering screens.
     */
    @FXML
    private Button basketMenuButton, coffeeMenuButton, donutMenuButton, ordersMenuButton;
    /**
     * ImageView that holds images on the corresponding buttons.
     */
    @FXML
    private ImageView donutImage, coffeeImage, basketImage, ordersImage;
    /**
     * JavaFX Stage to set the window.
     */
    private Stage stage;
    /**
     * JavaFX Scene to hold the GUI.
     */
    private Scene scene;
    /**
     * Parent object to hold the FXML file.
     */
    private Parent root;

    /**
     * Event Handler for the basket button.
     * Directs user to the ordering basket GUI.
     * @param event
     * @throws IOException
     */
    @FXML
    void onBasketClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("order-basket-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Event Handler for the coffee button.
     * Directs user to the coffee menu GUI.
     * @param event
     * @throws IOException
     */
    @FXML
    void onCoffeeClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("order-coffee-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Event Handler for the donut button.
     * Directs user to the donut menu GUI.
     * @param event
     * @throws IOException
     */
    @FXML
    void onDonutClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("order-donut-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Event Handler for the order button.
     * Directs user to the store orders GUI.
     * @param event
     * @throws IOException
     */
    @FXML
    void onOrdersClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("store-orders-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}