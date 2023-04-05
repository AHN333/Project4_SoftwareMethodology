package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class OrderBasketController {
    @FXML
    private ListView<?> ordersListView;

    @FXML
    private Button placeOrderButton, removeItemButton;

    @FXML
    private TextField subtotalTF, taxTF, totalTF;

    @FXML
    void onPlaceOrderClicked(ActionEvent event) {

    }

    @FXML
    void onRemoveItemClicked(ActionEvent event) {

    }
}
