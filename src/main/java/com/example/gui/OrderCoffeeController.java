package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderCoffeeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button addToOrderButton, backButton;

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
    @FXML
    void onBackButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
