package com.example.gui;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
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
import model.Donut;
import model.MenuItem;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Controller class for the donut menu.
 * @author William Barrese, Andy Nguyen
 */
public class OrderDonutController implements Initializable {
    /**
     * JavaFX Stage to set the window.
     */
    private Stage stage;
    /**
     * JavaFX Scene to hold the GUI.
     */
    private Scene scene;
    /**
     * Parent object to load the FXML file.
     */
    private Parent root;
    /**
     * ImageView for donut images.
     */
    @FXML
    private ImageView donutImage;
    /**
     * JavaFX buttons.
     * addToListButton adds selected donut properties to the cart.
     * addToOrderButton adds donuts from the cart to the ordering basket.
     * backButton navigates back to the main menu GUI.
     * removeFromListButton removes added donut from the cart.
     */
    @FXML
    private Button addToListButton, addToOrderButton, backButton, removeFromListButton;
    /**
     * JavaFX ComboBox to hold the type of donuts.
     */
    @FXML
    private ComboBox<String> donutTypeCombobox;
    /**
     * JavaFX ComboBox to hold the quantity of donuts.
     */
    @FXML
    private ComboBox<Integer> quantityCombobox;
    /**
     * JavaFX TextField to display the subtotal.
     */
    @FXML
    private TextField donutSubtotalTF;
    /**
     * JavaFX ListView to display the donut flavors.
     */
    @FXML
    private ListView<String> listViewFlavors;
    /**
     * JavaFX ListView to display the donuts added to the cart.
     */
    @FXML
    private ListView<MenuItem> listViewCart;
    /**
     * Array of Strings for yeast donut flavors.
     */
    private final String[] YEAST_FLAVORS = {"Plain", "Glazed", "Chocolate Iced", "Strawberry Iced", "Boston Creme", "Jelly Filled"};
    /**
     * String of Arrays for cake donut flavors.
     */
    private final String[] CAKE_FLAVORS = {"Plain", "Chocolate", "Lemon"};
    /**
     * String of Arrays for donut hole flavors.
     */
    private final String[] HOLE_FLAVORS = {"Plain", "Glazed", "Chocolate"};
    /**
     * ObservableList for yeast donut flavors.
     */
    private ObservableList<String> YEAST_FLAVOR_LIST = FXCollections.observableArrayList(YEAST_FLAVORS);
    /**
     * ObservableList for cake donut flavors.
     */
    private ObservableList<String> CAKE_FLAVOR_LIST = FXCollections.observableArrayList(CAKE_FLAVORS);
    /**
     * ObservableList for donut hole flavors.
     */
    private ObservableList<String> HOLE_FLAVOR_LIST = FXCollections.observableArrayList(HOLE_FLAVORS);
    /**
     * ArrayList for donuts in the cart.
     */
    private ArrayList<MenuItem> item = new ArrayList();
    /**
     * ObservableList for donuts added to the cart.
     */
    private ObservableList<MenuItem> CART_LIST = FXCollections.observableList(item);
    /**
     * Array of Strings for donuts types.
     */
    private final String[] DONUT_TYPES = {"Yeast Donut", "Cake Donut", "Donut Hole"};
    /**
     * ObservableList for donut types.
     */
    private final ObservableList<String> DONUT_TYPE_LIST = FXCollections.observableArrayList(DONUT_TYPES);
    /**
     * Array for Quantity allows user to add up to 12 donuts.
     */
    private final Integer[] QUANTITY = {1,2,3,4,5,6,7,8,9,10,11,12};
    /**
     * ObservableList for the quantity of donuts added.
     */
    private final ObservableList<Integer> QUANTITY_LIST = FXCollections.observableArrayList(QUANTITY);
    /**
     * Image object for yeast donut.
     */
    Image yeast = new Image(getClass().getResourceAsStream("yeastDonut.jpg"));
    /**
     * Image object for cake donut.
     */
    Image cake = new Image(getClass().getResourceAsStream("cake donut.jpg"));
    /**
     * Image object for donut hole.
     */
    Image hole = new Image(getClass().getResourceAsStream("donut holes.jpg"));

    /**
     * Method that changes image based on the type of donut selected in the ComboBox.
     */
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

    /**
     * Event Handler for add (>>) button.
     * Added selected donut flavor and quantity to the cart.
     * @param event
     */
    @FXML
    void onAddToListClicked(ActionEvent event) {
        String selectedItem = listViewFlavors.getSelectionModel().getSelectedItem();
        if (quantityCombobox.getSelectionModel().getSelectedItem() == null){
            return;
            // If the combobox is null just skip
        }
        int quantity = quantityCombobox.getSelectionModel().getSelectedItem();
        if (selectedItem != null && quantity > 0) {
            if (donutTypeCombobox.getValue().equals("Yeast Donut")) {
                listViewFlavors.setItems(YEAST_FLAVOR_LIST);
                YEAST_FLAVOR_LIST.remove(selectedItem);
                CART_LIST.add(new Donut(selectedItem, "Yeast Donut", quantity));
            } else if ((donutTypeCombobox.getValue().equals("Cake Donut"))) {
                listViewFlavors.setItems(CAKE_FLAVOR_LIST);
                CAKE_FLAVOR_LIST.remove(selectedItem);
                CART_LIST.add(new Donut(selectedItem, "Cake Donut", quantity));
            } else if ((donutTypeCombobox.getValue().equals("Donut Hole"))) {
                listViewFlavors.setItems(HOLE_FLAVOR_LIST);
                HOLE_FLAVOR_LIST.remove(selectedItem);
                CART_LIST.add(new Donut(selectedItem, "Donut Hole", quantity));
            }
        }
        updateList();
    }

    /**
     * Event Handler for the add to order button.
     * Adds the donuts from the cart to the ordering basket.
     * @param event
     * @throws IOException
     */
    @FXML
    void onAddToOrderClicked(ActionEvent event) throws IOException {

        //Add to full order
        for(MenuItem s : CART_LIST){
            MainController.CURRENT_ORDER.add(s);
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("order-basket-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Event Handler from the remove (<<) button.
     * Removes items from the cart back to the flavor list.
     * @param event
     */
    @FXML
    void onRemoveFromListClicked(ActionEvent event) {
        MenuItem selectedItem = listViewCart.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            YEAST_FLAVOR_LIST = FXCollections.observableArrayList(YEAST_FLAVORS);
            CAKE_FLAVOR_LIST = FXCollections.observableArrayList(CAKE_FLAVORS);
            HOLE_FLAVOR_LIST = FXCollections.observableArrayList(HOLE_FLAVORS);

            if (donutTypeCombobox.getValue().equals("Yeast Donut")) {
                listViewFlavors.setItems(YEAST_FLAVOR_LIST);
            } else if ((donutTypeCombobox.getValue().equals("Cake Donut"))) {
                listViewFlavors.setItems(CAKE_FLAVOR_LIST);
                CAKE_FLAVOR_LIST.remove(selectedItem);
            } else if ((donutTypeCombobox.getValue().equals("Donut Hole"))) {
                listViewFlavors.setItems(HOLE_FLAVOR_LIST);
            }

            CART_LIST.remove(selectedItem);
        }
        updateList();
    }

    /**
     * Event Handler for the back to menu button.
     * Navigates the user back to the main menu GUI.
     * @param event
     * @throws IOException
     */
    @FXML
    void onBackButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * JavaFX Initializable method to update the subtotal. Populates the donut type ComboBox and quantity ComboBox.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        donutTypeCombobox.setItems(DONUT_TYPE_LIST);
        quantityCombobox.setItems(QUANTITY_LIST);
        updateList();
    }

    /**
     * Method to update the subtotal and cart.
     */
    private void updateList(){
        ObservableList<MenuItem> tempList = FXCollections.observableArrayList();
        double sub = 0.0;
        for (MenuItem s : CART_LIST){
//            Donut donut = (Donut) s;
            sub += s.itemPrice();
//            tempList.add(donut.getFlavor() + " " + donut.getType() + "\tx" + donut.getQuantity());
            tempList.add(s);
        }
        donutSubtotalTF.setText(Math.round(sub * 100.0)/100.0 + "");
        listViewCart.setItems(tempList);
    }

}
