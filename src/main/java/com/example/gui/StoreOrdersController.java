package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrdersController {
    @FXML
    private Button cancelOrderButton, exportOrderButton;

    @FXML
    private ComboBox<?> orderNumCombobox;
    @FXML
    private ListView<?> storeOrdersListView;

    @FXML
    private TextField totalTF;

    @FXML
    void onCancelOrderClicked(ActionEvent event) {

    }

    @FXML
    void onExportOrderClicked(ActionEvent event) {

    }
}
