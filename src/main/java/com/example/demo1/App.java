package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    int i;
    @Override
    public void start(Stage stage) throws IOException {
        fill_map();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 700);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.show();
    }

    public static void fill_map(){
//      0 - empty; 1 - X; 2 - O
        Controller.setMap(1, 3);
        Controller.setMap(2, 4);
        Controller.setMap(3, 5);
        Controller.setMap(4, 6);
        Controller.setMap(5, 7);
        Controller.setMap(6, 8);
        Controller.setMap(7, 9);
        Controller.setMap(8, 10);
        Controller.setMap(9, 11);

    }

    public static void main(String[] args) {
        launch();
    }
}