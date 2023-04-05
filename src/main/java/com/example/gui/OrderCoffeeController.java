package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OrderCoffeeController {
    @FXML
    private Button addToOrderButton;

    @FXML
    private CheckBox caramelCbox, irishCbox, mochaCbox, sweetCreamCBox, vanillaCbox;

    @FXML
    private RadioButton grandeRB, shortRB, ventiRB, tallRB;

    @FXML
    private ComboBox<?> quantityCombobox;

    @FXML
    private ToggleGroup sizeToggleGrp;

    @FXML
    private TextField subtotalTF;

    @FXML
    void onAddToOrderClicked(ActionEvent event) {

    }
}
