package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class OrderDonutController {
    @FXML
    private Button addToListButton, addToOrderButton;

    @FXML
    private ComboBox<?> cboxDonutType, cboxQuantity;

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

}
