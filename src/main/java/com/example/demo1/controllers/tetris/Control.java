package com.example.demo1.controllers.tetris;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Control {
    @FXML
    private GridPane grid;
    private static Rectangle[][] field = new Rectangle[10][20];
    private Color transparent = new Color(0f,0f,0f,0f );


    @FXML
    void start(ActionEvent event) {
        if (field[1][1] != null) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    field[i][j] = null;
                }
            }
            grid.setGridLinesVisible(false);
            grid.getColumnConstraints().clear();
            grid.getRowConstraints().clear();
            grid.getChildren().clear();
            grid.setGridLinesVisible(true);
        }

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 20; j++){
                field[i][j] = new Rectangle(40, 33, transparent);
                grid.add(field[i][j], i, j);
            }
        }
    }
    @FXML
    void key(KeyEvent event) {
        System.out.print(event.getCode() + "  ");

        switch (event.getCode()){
            case I:
                Tetramino.makeI();
                Tetramino i = new Tetramino();
                print(i);
                break;
            case J:
                Tetramino.makeJ();
                Tetramino j = new Tetramino();
                print(j);
                break;
            case L:
                Tetramino.makeL();
                Tetramino l = new Tetramino();
                print(l);
                break;
            case O:
                Tetramino.makeO();
                Tetramino o = new Tetramino();
                print(o);
                break;
            case S:
                Tetramino.makeS();
                Tetramino s = new Tetramino();
                print(s);
                break;
            case T:
                Tetramino.makeT();
                Tetramino t = new Tetramino();
                print(t);
                break;
            case Z:
                Tetramino.makeZ();
                Tetramino z = new Tetramino();
                print(z);
                break;
        }
    }
    private static void print(Tetramino tetramino){
        for (int i = 0; i <= 4; i++) {
            field[Tetramino.getCoord(i)[0]][tetramino.getCoord(i)[1]].setFill(Paint.valueOf(Tetramino.getColor()));
        }
    }
    private static void print(int column, int row){
        field[column][row].setFill(Paint.valueOf("green"));
    }
}
