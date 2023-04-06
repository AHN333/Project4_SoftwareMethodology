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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.group9.model.MenuItem;
import com.group9.model.Order;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for store orders.
 * Holds event handlers for Store Orders GUI.
 * @author William Barrese, Andy Nguyen
 */
public class StoreOrdersController implements Initializable {
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
     * cancelOrderButton removes the order from the store orders.
     * exportOrderButton allows the user to export the order to a file.
     * backButton navigates back to the main menu GUI.
     */
    @FXML
    private Button cancelOrderButton, exportOrderButton, backButton;
    /**
     * JavaFX comboboxes.
     * orderNumCombobox holds the different orders placed.
     */
    @FXML
    private ComboBox<Integer> orderNumCombobox;
    /**
     * JavaFX ListView for menu items.
     * storeOrdersListView holds the orders placed.
     */
    @FXML
    private ListView<MenuItem> storeOrdersListView;

    /**
     * JavaFX TextField.
     * totalTF displays the total price for the order.
     */
    @FXML
    private TextField totalTF;

    /**
     *JavaFX Initializable method used to update the listview with the orders.
     * @param url Auto-generated url for javafx
     * @param resourceBundle Auto-generated resource bundle for javafx
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Integer> indices = FXCollections.observableArrayList();
        for (Order order: MainController.FINALIZED_ORDERS) {
            indices.add(order.getOrderNumber());
        }
        orderNumCombobox.setItems(indices);
    }

    /**
     * Event Handler for the cancel order button.
     * Removes the order from the store orders.
     * @param event
     */
    @FXML
    void onCancelOrderClicked(ActionEvent event) {
        if(orderNumCombobox.getValue() != null){
            int orderNum = orderNumCombobox.getValue();
            MainController.FINALIZED_ORDERS.removeIf(order -> order.getOrderNumber()==orderNum);
            storeOrdersListView.setItems(FXCollections.observableArrayList());
            totalTF.setText("");
        }
    }

    /**
     * Event Listener for order number combobox.
     * Tracks different orders based on the order number selected.
     * @param event
     */
    @FXML
    void onOrderSelected(ActionEvent event){
        int orderNum = orderNumCombobox.getValue();
        Order order = MainController.FINALIZED_ORDERS.stream().filter(ord -> ord.getOrderNumber()==orderNum).findAny().orElseThrow();
        updateList(order);
    }

    /**
     * Method to update the listview with the order selected.
     * Displays the total amount for that order.
     * @param order
     */
    private void updateList(Order order){
        storeOrdersListView.setItems(FXCollections.observableArrayList(order.getMenuItems()));
        totalTF.setText(Math.round(order.getTotal()*100.0)/100.0 +"");
    }

    /**
     * Event Handler for the export order button.
     * Allows the user to export the current order to a file.
     * @param event
     */
    @FXML
    void onExportOrderClicked(ActionEvent event) {
        if(orderNumCombobox.getValue() != null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Export order");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File selectedFile = fileChooser.showSaveDialog(stage);
//        selectedFile.
            try {
                PrintWriter writer;
                writer = new PrintWriter(selectedFile);
                String content = "";
                Order selectedOrder = MainController.FINALIZED_ORDERS.stream().filter(order -> order.getOrderNumber() == orderNumCombobox.getValue()).findAny().orElseThrow();
                double sub = 0.0;
                for (MenuItem item : selectedOrder.getMenuItems()) {
                    sub += item.itemPrice();
                    content += item.toString() + "\t " + Math.round(item.itemPrice() * 100.0)/100.0 + "\n";
                }
                content += "Sub: " + Math.round(sub * 100.0)/100.0 + "\n";
                content += "Tax: " + Math.round((MenuItem.TAX * sub)*100.0)/100.0 + "\n";
                content += "Total: " + Math.round(selectedOrder.getTotal()*100.0)/100.0 +"\n";
                writer.println(content);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
