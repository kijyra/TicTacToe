package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainControl {
    @FXML
    private Button ticButton;

    @FXML
    void ticAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ticView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 700);
        Stage ticTacToe = new Stage();
        ticTacToe.setResizable(false);
        ticTacToe.setScene(scene);
        ticTacToe.setTitle("Крестики-нолики");
        ticTacToe.show();
    }

    @FXML
    void tetrisAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tetrisView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 700);
        Stage tetris = new Stage();
        tetris.setResizable(false);
        tetris.setScene(scene);
        tetris.setTitle("Тетрис");

        tetris.show();
    }
}
