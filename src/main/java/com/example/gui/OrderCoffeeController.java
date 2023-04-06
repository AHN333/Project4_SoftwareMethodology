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
    private GridPane coffeeGrid;

//    @FXML
//    private HBox sizeGrid;

    @FXML
    private BorderPane coffeeBorderPane;

    @FXML
    private TextField subtotalTF;
    private final Integer[] QUANTITY = {1,2,3,4};
    private final ObservableList<Integer> QUANTITY_LIST= FXCollections.observableArrayList(QUANTITY);

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
