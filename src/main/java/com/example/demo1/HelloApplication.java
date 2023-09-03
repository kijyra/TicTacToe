package com.example.demo1;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.cert.X509Certificate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        fill_map();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 700);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.show();

    }

    public static void fill_map(){
//      0 - empty; 1 - X; 2 - O
        HelloController.setMap(1, 3);
        HelloController.setMap(2, 4);
        HelloController.setMap(3, 5);
        HelloController.setMap(4, 6);
        HelloController.setMap(5, 7);
        HelloController.setMap(6, 8);
        HelloController.setMap(7, 9);
        HelloController.setMap(8, 10);
        HelloController.setMap(9, 11);

    }

    public static void main(String[] args) {
        launch();
    }
}