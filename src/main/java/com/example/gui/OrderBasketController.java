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
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MenuItem;
import model.Order;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderBasketController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<MenuItem> ordersListView;
    private final String ITEM[] = {};

    @FXML
    private Button placeOrderButton, removeItemButton, backButton;

    @FXML
    private TextField subtotalTF, taxTF, totalTF;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList();
    }

    private void updateList(){
        double sub =0.0;
        ObservableList<MenuItem> tempList = FXCollections.observableArrayList();
        for (MenuItem s : MainController.CURRENT_ORDER.getMenuItems()){
            tempList.add(s);
            sub += s.itemPrice();
        }
        subtotalTF.setText(Math.round(sub * 100.0)/100.0 + "");
        double tax = Math.round((sub * MenuItem.TAX) * 100.0)/100.0;
        taxTF.setText(tax + "");
        totalTF.setText(Math.round((tax + sub) * 100.0)/100.0 + "");
        ordersListView.setItems(tempList);
    }

    @FXML
    void onPlaceOrderClicked(ActionEvent event) {
        int currentOrderIndex = MainController.CURRENT_ORDER.getOrderNumber();
        MainController.FINALIZED_ORDERS.add(MainController.CURRENT_ORDER);
        MainController.CURRENT_ORDER = new Order(currentOrderIndex+1);
        updateList();
    }

    @FXML
    void onRemoveItemClicked(ActionEvent event) {
        MenuItem selectedItem = ordersListView.getSelectionModel().getSelectedItem();
//        selectedItem = selectedItem.substring(0,selectedItem.indexOf("\t"));
        MainController.CURRENT_ORDER.remove(selectedItem);
        updateList();
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
