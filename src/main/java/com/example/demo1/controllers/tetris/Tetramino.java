package com.example.demo1.controllers.tetris;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Tetramino {
    private static String color;
    private static int xy[] = new int[8];
    private static Character tetramino;
    public static int[] getCoord(int cell){
        int currentCell[] = new int[2];
        if (cell <= 4){
            switch (cell){
                case 1:
                    currentCell[0] = xy[0];
                    currentCell[1] = xy[1];
                    return currentCell;
                case 2:
                    currentCell[0] = xy[2];
                    currentCell[1] = xy[3];
                    return currentCell;
                case 3:
                    currentCell[0] = xy[4];
                    currentCell[1] = xy[5];
                    return currentCell;
                case 4:
                    currentCell[0] = xy[6];
                    currentCell[1] = xy[7];
                    return currentCell;
            }
            return currentCell;
        } else return currentCell;
    }

    public void moveToLeft(){
        for (int i = 0; i <= 7; i = i + 2) {
            if (xy[i] != 0) xy[i] -= 1;
            else {
                switch (tetramino) {
                    case 'I':
                        xy[0] = 0;
                        xy[2] = 0;
                        xy[4] = 0;
                        xy[6] = 0;
                        break;
                    case 'J':
                        xy[0] = 1;
                        xy[2] = 1;
                        xy[4] = 1;
                        xy[6] = 0;
                        break;
                    case 'L':
                        xy[0] = 0;
                        xy[2] = 0;
                        xy[4] = 0;
                        xy[6] = 1;
                        break;
                    case 'O':
                        xy[0] = 0;
                        xy[2] = 0;
                        xy[4] = 1;
                        xy[6] = 1;
                        break;
                    case 'S':
                        xy[0] = 1;
                        xy[2] = 2;
                        xy[4] = 1;
                        xy[6] = 0;
                        break;
                    case 'T':
                        xy[0] = 0;
                        xy[2] = 1;
                        xy[4] = 2;
                        xy[6] = 1;
                        break;
                    case 'Z':
                        xy[0] = 1;
                        xy[2] = 0;
                        xy[4] = 1;
                        xy[6] = 2;
                        break;
                }
                i = 7;
            }
        }
    }
    public void moveToRight(){
        for (int i = 0; i <= 7; i = i + 2) {
            if (xy[i] != 9 ) xy[i] += 1;
            else {
                switch (tetramino){
                    case 'I':
                        xy[0] = 9;
                        xy[2] = 9;
                        xy[4] = 9;
                        xy[6] = 9;
                        break;
                    case 'J':
                        xy[0] = 8;
                        xy[2] = 8;
                        xy[4] = 8;
                        xy[6] = 9;
                        break;
                    case 'L':
                        xy[0] = 9;
                        xy[2] = 9;
                        xy[4] = 9;
                        xy[6] = 8;
                        break;
                    case 'O':
                        xy[0] = 8;
                        xy[2] = 8;
                        xy[4] = 9;
                        xy[6] = 9;
                        break;
                    case 'S':
                        xy[0] = 8;
                        xy[2] = 9;
                        xy[4] = 8;
                        xy[6] = 7;
                        break;
                    case 'T':
                        xy[0] = 7;
                        xy[2] = 8;
                        xy[4] = 9;
                        xy[6] = 8;
                        break;
                    case 'Z':
                        xy[0] = 8;
                        xy[2] = 7;
                        xy[4] = 8;
                        xy[6] = 9;
                        break;
                }
                i = 10;
            }
        }
    }
    public void move(){
        xy[1] += 1;
        xy[3] += 1;
        xy[5] += 1;
        xy[7] += 1;
    }
    public static String getColor(){
        return color;
    }
    public static void makeI(){
        tetramino = 'I';
        color = "green";
        xy[0] = 5; xy[1] = 0;
        xy[2] = 5; xy[3] = 1;
        xy[4] = 5; xy[5] = 2;
        xy[6] = 5; xy[7] = 3;
    }
    public static void makeJ(){
        tetramino = 'J';
        color = "blue";
        xy[0] = 5; xy[1] = 0;
        xy[2] = 5; xy[3] = 1;
        xy[4] = 5; xy[5] = 2;
        xy[6] = 4; xy[7] = 2;
    }
    public static void makeL(){
        tetramino = 'L';
        color = "red";
        xy[0] = 5; xy[1] = 0;
        xy[2] = 5; xy[3] = 1;
        xy[4] = 5; xy[5] = 2;
        xy[6] = 6; xy[7] = 2;
    }
    public static void makeO(){
        tetramino = 'O';
        color = "yellow";
        xy[0] = 5; xy[1] = 0;
        xy[2] = 5; xy[3] = 1;
        xy[4] = 6; xy[5] = 0;
        xy[6] = 6; xy[7] = 1;
    }
    public static void makeS(){
        tetramino = 'S';
        color = "orange";
        xy[0] = 5; xy[1] = 0;
        xy[2] = 6; xy[3] = 0;
        xy[4] = 5; xy[5] = 1;
        xy[6] = 4; xy[7] = 1;
    }
    public static void makeT(){
        tetramino = 'T';
        color = "purple";
        xy[0] = 4; xy[1] = 0;
        xy[2] = 5; xy[3] = 0;
        xy[4] = 6; xy[5] = 0;
        xy[6] = 5; xy[7] = 1;
    }
    public static void makeZ(){
        tetramino = 'Z';
        color = "lightblue";
        xy[0] = 5; xy[1] = 0;
        xy[2] = 4; xy[3] = 0;
        xy[4] = 5; xy[5] = 1;
        xy[6] = 6; xy[7] = 1;
    }
}
