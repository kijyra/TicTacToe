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
    private Tetramino currentTetramino;
    private Tetramino[] tetramino[];


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
                currentTetramino = new Tetramino();
                print(currentTetramino);
                break;
            case J:
                Tetramino.makeJ();
                currentTetramino = new Tetramino();
                print(currentTetramino);
                break;
            case L:
                Tetramino.makeL();
                currentTetramino = new Tetramino();
                print(currentTetramino);
                break;
            case O:
                Tetramino.makeO();
                currentTetramino = new Tetramino();
                print(currentTetramino);
                break;
            case S:
                Tetramino.makeS();
                currentTetramino = new Tetramino();
                print(currentTetramino);
                break;
            case T:
                Tetramino.makeT();
                currentTetramino = new Tetramino();
                print(currentTetramino);
                break;
            case Z:
                Tetramino.makeZ();
                currentTetramino = new Tetramino();
                print(currentTetramino);
                break;
            case A:
                erase(currentTetramino);
                currentTetramino.moveToLeft();
                print(currentTetramino);
                break;
            case D:
                erase(currentTetramino);
                currentTetramino.moveToRight();
                print(currentTetramino);
                break;
        }
    }

    private static void erase(Tetramino tetramino){
        for (int i = 1; i <= 4; i++) {
            field[Tetramino.getCoord(i)[0]][tetramino.getCoord(i)[1]].setFill(Color.TRANSPARENT);
        }
    }
    private static void print(Tetramino tetramino){
        for (int i = 1; i <= 4; i++) {
            field[Tetramino.getCoord(i)[0]][tetramino.getCoord(i)[1]].setFill(Paint.valueOf(Tetramino.getColor()));
        }
    }
    private static void print(int column, int row){
        field[column][row].setFill(Paint.valueOf("green"));
    }
}
