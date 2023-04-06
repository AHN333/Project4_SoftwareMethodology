package com.group9.cafe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Cafe Application class
 * @author Wiliam Barrese, Andy Nguyen
 */
public class CafeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CafeApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 550);
        stage.setTitle("RU Cafe");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Start Cafe GUI
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}