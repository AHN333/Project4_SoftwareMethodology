package com.example.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Coffee;
import model.MenuItem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Math.round;

/**
 * Controller class for ordering coffee.
 * Holds the event handlers for the Coffee Menu GUI.
 * @author William Barrese, Andy Nguyen
 */
public class OrderCoffeeController implements Initializable {
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
     * JavaFX buttons.
     * addToOrderButton adds selected properties to the shopping basket.
     * backButton navigates back the main menu GUI.
     */
    @FXML
    private Button addToOrderButton, backButton;
    /**
     * JavaFX checkboxes for different add-ons to the coffee.
     */
    @FXML
    private CheckBox caramelCbox, irishCbox, mochaCbox, sweetCreamCBox, vanillaCbox;
    /**
     * JavaFX radiobuttons for the different cup sizes.
     */
    @FXML
    private RadioButton grandeRB, shortRB, ventiRB, tallRB;
    /**
     * JavaFX combobox for the quantity of coffees.
     */
    @FXML
    private ComboBox<Integer> quantityCombobox;
    /**
     * JavaFX toggle group for the cup size radiobuttons.
     */
    @FXML
    private ToggleGroup sizeToggleGrp;
    /**
     * JavaFX GridPane for the GUI.
     */
    @FXML
    private GridPane coffeeGrid;

//    @FXML
//    private HBox sizeGrid;
    /**
     * JavaFX BorderPane for the GUI.
     */
    @FXML
    private BorderPane coffeeBorderPane;
    /**
     * JavaFX TextField that displays the subtotal for the coffee.
     */
    @FXML
    private TextField subtotalTF;
    /**
     * Quantity array that only allows the user to select up to 4 coffees.
     */
    private final Integer[] QUANTITY = {1,2,3,4};
    /**
     * ObservableList for the quantity of coffees.
     */
    private final ObservableList<Integer> QUANTITY_LIST= FXCollections.observableArrayList(QUANTITY);

    /**
     *Event Handler for add to order button.
     * Sends the selected coffee properties to the shopping basket.
     * @param event
     * @throws IOException
     */
    @FXML
    void onAddToOrderClicked(ActionEvent event) throws IOException {

        if(sizeToggleGrp.getSelectedToggle() != null || quantityCombobox.getValue() != null) {
            ArrayList<String> addons = new ArrayList<>();
            if(caramelCbox.isSelected()) addons.add("Caramel");
            if(sweetCreamCBox.isSelected()) addons.add("Sweet Cream");
            if(irishCbox.isSelected()) addons.add("Irish Cream");
            if(mochaCbox.isSelected()) addons.add("Mocha");
            if(vanillaCbox.isSelected()) addons.add("Vanilla");
            String size = ((RadioButton) sizeToggleGrp.getSelectedToggle()).getText();
            Coffee coffee = new Coffee(size, addons, quantityCombobox.getValue());

            MainController.CURRENT_ORDER.add(coffee);
        }else{
            //If any of above are null skip
            return;
        }

        //Add to order
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("order-basket-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Event handler for the Back to Menu button.
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

    /**
     * JavaFX Initializable method to update the subtotal real-time.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quantityCombobox.setItems(QUANTITY_LIST);
        for (Node node:
                coffeeGrid.getChildren()) {
            if(node instanceof CheckBox ){
                ((CheckBox) node).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        calcSub();
                    }
                });
            } else if (node instanceof ComboBox<?>) {
                ((ComboBox) node).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        calcSub();
                    }
                });
            }
        }
        for (Toggle node:
             sizeToggleGrp.getToggles()) {
            ((RadioButton) node).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    calcSub();
                }
            });
        }
    }

    /**
     * Method to calculate the subtotal based on the selected coffee properties.
     */
    private void calcSub(){
        try{
            double sub = 0.0;
            if(caramelCbox.isSelected()) sub+= MenuItem.ADDON_PRICE;
            if(sweetCreamCBox.isSelected()) sub+= MenuItem.ADDON_PRICE;
            if(irishCbox.isSelected()) sub+= MenuItem.ADDON_PRICE;
            if(mochaCbox.isSelected()) sub+= MenuItem.ADDON_PRICE;
            if(vanillaCbox.isSelected()) sub+= MenuItem.ADDON_PRICE;
            sub += MenuItem.SIZE_MAP.get(((RadioButton)this.sizeToggleGrp.getSelectedToggle()).getText().toLowerCase());
            sub *= quantityCombobox.getValue();
            subtotalTF.setText(Math.round(sub * 100.0)/100.0 +"");
        } catch (NullPointerException e){
            // If any of the above are null we just dont show the sub
        }
    }
}
