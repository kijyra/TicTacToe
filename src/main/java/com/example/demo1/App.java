package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    private static int selectedGame = 0;
    public void setSelectedGame(int num){
        selectedGame = num;
    }
    public int getSelectedGame(){
        return selectedGame;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(App.class.getResource("mainView.fxml"));
        Scene mainScene = new Scene(mainLoader.load(), 250, 400);
        stage.setResizable(false);
        stage.setScene(mainScene);
        stage.setTitle("Games");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}