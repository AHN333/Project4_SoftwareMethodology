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
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Coffee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderCoffeeController implements Initializable {
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
    private ComboBox<Integer> quantityCombobox;

    @FXML
    private ToggleGroup sizeToggleGrp;

    @FXML
    private TextField subtotalTF;
    private final Integer[] QUANTITY = {1,2,3,4};
    private final ObservableList<Integer> QUANTITY_LIST= FXCollections.observableArrayList(QUANTITY);

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quantityCombobox.setItems(QUANTITY_LIST);
    }
}
