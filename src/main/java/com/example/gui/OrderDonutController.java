package com.example.gui;

import javafx.beans.Observable;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderDonutController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView donutImage;
    @FXML
    private Button addToListButton, addToOrderButton, backButton;

    @FXML
    private ComboBox<String> donutTypeCombobox;
    @FXML
    private ComboBox<Integer> quantityCombobox;

    @FXML
    private TextField donutSubtotalTF;

    @FXML
    private ListView<String> listViewCart, listViewFlavors;
    private final String[] YEAST_FLAVORS = {"Plain", "Glazed", "Chocolate Iced", "Strawberry Iced", "Boston Creme", "Jelly Filled"};
    private final String[] CAKE_FLAVORS = {"Plain", "Chocolate", "Lemon"};
    private final String[] HOLE_FLAVORS = {"Plain", "Glazed", "Chocolate"};
    private ObservableList<String> YEAST_FLAVOR_LIST = FXCollections.observableArrayList(YEAST_FLAVORS);
    private ObservableList<String> CAKE_FLAVOR_LIST = FXCollections.observableArrayList(CAKE_FLAVORS);
    private ObservableList<String> HOLE_FLAVOR_LIST = FXCollections.observableArrayList(HOLE_FLAVORS);
    private ArrayList<String> item = new ArrayList();
    private ObservableList<String> CART_LIST = FXCollections.observableArrayList(item);

    @FXML
    private Button removeFromListButton;
    private final String[] DONUT_TYPES = {"Yeast Donut", "Cake Donut", "Donut Hole"};
    private final ObservableList<String> DONUT_TYPE_LIST = FXCollections.observableArrayList(DONUT_TYPES);
    private final Integer[] QUANTITY = {1,2,3,4,5,6,7,8,9,10,11,12};
    private final ObservableList<Integer> QUANTITY_LIST = FXCollections.observableArrayList(QUANTITY);
    @FXML
    void onAddToListClicked(ActionEvent event) {
        String selectedItem = listViewFlavors.getSelectionModel().getSelectedItem();
        if (selectedItem != null)
        YEAST_FLAVOR_LIST.remove(selectedItem);
        CART_LIST.add(selectedItem);
    }

    @FXML
    void onAddToOrderClicked(ActionEvent event) {

    }

    @FXML
    void onRemoveFromListClicked(ActionEvent event) {
        String selectedItem = listViewCart.getSelectionModel().getSelectedItem();
        if (selectedItem != null)
        YEAST_FLAVOR_LIST.add(selectedItem);
        CART_LIST.remove(selectedItem);
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
        donutTypeCombobox.setItems(DONUT_TYPE_LIST);
        quantityCombobox.setItems(QUANTITY_LIST);
        listViewFlavors.setItems(YEAST_FLAVOR_LIST);
        listViewCart.setItems(CART_LIST);
    }

    void getSelected(ActionEvent actionEvent){
        String selected = donutTypeCombobox.getSelectionModel().getSelectedItem().toString();
        if (selected =="Yeast Donut"){
            listViewFlavors.setItems(YEAST_FLAVOR_LIST);
        }
    }
}
