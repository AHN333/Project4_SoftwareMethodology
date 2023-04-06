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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.MenuItem;
import model.Order;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreOrdersController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button cancelOrderButton, exportOrderButton, backButton;

    @FXML
    private ComboBox<Integer> orderNumCombobox;
    @FXML
    private ListView<MenuItem> storeOrdersListView;

    @FXML
    private TextField totalTF;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Integer> indices = FXCollections.observableArrayList();
        for (Order order: MainController.FINALIZED_ORDERS) {
            indices.add(order.getOrderNumber());
        }
        orderNumCombobox.setItems(indices);
    }

    @FXML
    void onCancelOrderClicked(ActionEvent event) {
        if(orderNumCombobox.getValue() != null){
            int orderNum = orderNumCombobox.getValue();
            MainController.FINALIZED_ORDERS.removeIf(order -> order.getOrderNumber()==orderNum);
            storeOrdersListView.setItems(FXCollections.observableArrayList());
            totalTF.setText("");
        }
    }

    @FXML
    void onOrderSelected(ActionEvent event){
        int orderNum = orderNumCombobox.getValue();
        Order order = MainController.FINALIZED_ORDERS.stream().filter(ord -> ord.getOrderNumber()==orderNum).findAny().orElseThrow();
        updateList(order);
    }

    private void updateList(Order order){
        storeOrdersListView.setItems(FXCollections.observableArrayList(order.getMenuItems()));
        totalTF.setText(Math.round(order.getTotal()*100.0)/100.0 +"");
    }

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
    @FXML
    void onBackButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
