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
import javafx.scene.image.Image;
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
    private Button addToListButton, addToOrderButton, backButton, removeFromListButton;

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

    private final String[] DONUT_TYPES = {"Yeast Donut", "Cake Donut", "Donut Hole"};
    private final ObservableList<String> DONUT_TYPE_LIST = FXCollections.observableArrayList(DONUT_TYPES);
    private final Integer[] QUANTITY = {1,2,3,4,5,6,7,8,9,10,11,12};
    private final ObservableList<Integer> QUANTITY_LIST = FXCollections.observableArrayList(QUANTITY);

    Image yeast = new Image(getClass().getResourceAsStream("yeastDonut.jpg"));
    Image cake = new Image(getClass().getResourceAsStream("cake donut.jpg"));
    Image hole = new Image(getClass().getResourceAsStream("donut holes.jpg"));
    public void display(){
        if (donutTypeCombobox.getValue().equals("Yeast Donut")) {
            donutImage.setImage(yeast);
            listViewFlavors.setItems(YEAST_FLAVOR_LIST);
        } else if ((donutTypeCombobox.getValue().equals("Cake Donut"))){
            donutImage.setImage(cake);
            listViewFlavors.setItems(CAKE_FLAVOR_LIST);
        } else if ((donutTypeCombobox.getValue().equals("Donut Hole"))){
            donutImage.setImage(hole);
            listViewFlavors.setItems(HOLE_FLAVOR_LIST);
        }
    }
    @FXML
    void onAddToListClicked(ActionEvent event) {
        String selectedItem = listViewFlavors.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (donutTypeCombobox.getValue().equals("Yeast Donut")) {
                listViewFlavors.setItems(YEAST_FLAVOR_LIST);
                YEAST_FLAVOR_LIST.remove(selectedItem);
                CART_LIST.add(selectedItem);
            } else if ((donutTypeCombobox.getValue().equals("Cake Donut"))) {
                listViewFlavors.setItems(CAKE_FLAVOR_LIST);
                CAKE_FLAVOR_LIST.remove(selectedItem);
                CART_LIST.add(selectedItem);
            } else if ((donutTypeCombobox.getValue().equals("Donut Hole"))) {
                listViewFlavors.setItems(HOLE_FLAVOR_LIST);
                HOLE_FLAVOR_LIST.remove(selectedItem);
                CART_LIST.add(selectedItem);
            }
        }
    }

    @FXML
    void onAddToOrderClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("order-basket-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

    @FXML
    void onRemoveFromListClicked(ActionEvent event) {
        String selectedItem = listViewCart.getSelectionModel().getSelectedItem();
        if (selectedItem != null)
        YEAST_FLAVOR_LIST.add(selectedItem);
        CAKE_FLAVOR_LIST.add(selectedItem);
        HOLE_FLAVOR_LIST.add(selectedItem);
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
        listViewCart.setItems(CART_LIST);
    }


    void getSelected(ActionEvent actionEvent){ // want to change listview when different combobox item is selected
        String selected = donutTypeCombobox.getSelectionModel().getSelectedItem().toString();
        if (selected =="Yeast Donut"){
            listViewFlavors.setItems(YEAST_FLAVOR_LIST);
        }
    }
}
