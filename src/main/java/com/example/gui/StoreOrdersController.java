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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.MenuItem;
import model.Order;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreOrdersController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button cancelOrderButton, exportOrderButton, backButton;

    @FXML
    private ComboBox<Integer> orderNumCombobox;
    @FXML
    private ListView<MenuItem> storeOrdersListView;

    @FXML
    private TextField totalTF;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Integer> indices = FXCollections.observableArrayList();
        for(int i = 0; i < MainController.CURRENT_ORDER.getOrderNumber()-1; i++){
            indices.add(i);
        }
        orderNumCombobox.setItems(indices);
    }

    @FXML
    void onCancelOrderClicked(ActionEvent event) {

    }

    @FXML
    void onOrderSelected(ActionEvent event){
        int index = orderNumCombobox.getValue();
        Order order = MainController.FINALIZED_ORDERS.get(index);
        updateList(order);
    }

    private void updateList(Order order){
        storeOrdersListView.setItems(FXCollections.observableArrayList(order.getMenuItems()));
        totalTF.setText(Math.round(order.getTotal()*100.0)/100.0 +"");
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
