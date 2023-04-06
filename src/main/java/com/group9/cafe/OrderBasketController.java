package com.group9.cafe;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.group9.model.MenuItem;
import com.group9.model.Order;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the Ordering Basket.
 * Holds event handlers for the Ordering Basket GUI.
 * @author William Barrese, Andy Nguyen
 */
public class OrderBasketController implements Initializable{
    /**
     * JavaFX Stage sets the window
     */
    private Stage stage;
    /**
     * JavaFX scene holds the GUI
     */
    private Scene scene;
    /**
     * Parent class holds the FXMLLoader to load fxml file
     */
    private Parent root;
    /**
     * ListView for the orders placed
     */
    @FXML
    private ListView<MenuItem> ordersListView;
    /**
     *Array of Strings that hold the menu items
     */
    private final String ITEM[] = {};
    /**
     *JavaFX buttons.
     * placeOrderButton sends the items in the shopping basket to the Store Orders.
     * removeItemButton removes selected items from the shopping basket.
     * backButton navigates the stage back to the main menu GUI.
     */
    @FXML
    private Button placeOrderButton, removeItemButton, backButton;
    /**
     *JavaFX Textfields.
     * subtotalTF displays the subtotal for the ordered items from the shopping basket.
     * taxTF displays the tax amount for the ordered items from the shopping basket.
     * totalTF displays the sum of the subttotal and tax TextFields.
     */
    @FXML
    private TextField subtotalTF, taxTF, totalTF;
    /**
     *JavaFX Initializable method used to update the shopping basket.
     * @param url Auto-generated url for javafx
     * @param resourceBundle Auto-generated resource bundle for javafx
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList();
    }
    /**
     *Method to update the shopping basket.
     */
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
    /**
     *Event handler for the place order button.
     * Sends items from shopping basket to Store Orders.
     * @param event
     */
    @FXML
    void onPlaceOrderClicked(ActionEvent event) {
        int currentOrderIndex = MainController.CURRENT_ORDER.getOrderNumber();
        MainController.FINALIZED_ORDERS.add(MainController.CURRENT_ORDER);
        MainController.CURRENT_ORDER = new Order(currentOrderIndex+1);
        updateList();
    }
    /**
     *Event handler for remove item button.
     * Removes selected item from shopping basket.
     * @param event
     */
    @FXML
    void onRemoveItemClicked(ActionEvent event) {
        MenuItem selectedItem = ordersListView.getSelectionModel().getSelectedItem();
//        selectedItem = selectedItem.substring(0,selectedItem.indexOf("\t"));
        MainController.CURRENT_ORDER.remove(selectedItem);
        updateList();
    }
    /**
     *Event handler for the Back to Menu button.
     * Redirects the user back the main menu.
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


}
