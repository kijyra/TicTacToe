package com.example.demo1;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.RadioButton;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Pane cell1;
    @FXML
    private Pane cell2;
    @FXML
    private Pane cell3;
    @FXML
    private Pane cell4;
    @FXML
    private Pane cell5;
    @FXML
    private Pane cell6;
    @FXML
    private Pane cell7;
    @FXML
    private Pane cell8;
    @FXML
    private Pane cell9;
    @FXML
    private Text t1;
    @FXML
    private Text t2;
    @FXML
    private Text t3;
    @FXML
    private Text t4;
    @FXML
    private Text t5;
    @FXML
    private Text t6;
    @FXML
    private Text t7;
    @FXML
    private Text t8;
    @FXML
    private Text t9;
    @FXML
    private Text text;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;


    private final static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private Boolean player_move = true;
    public static void setMap(int position, int value){
        map.put(position,value);
    }
    public static int getMap(int position){
        return map.get(position);
    }
    Background pane_background;
    Integer turn = 0;
    public static Boolean game_started = false;
    public static Integer counter = 0;

    @FXML
    void click_cell1() {
        if (game_started) move(t1, 1);
    }
    @FXML
    void click_cell2() {
        if (game_started) move(t2, 2);
    }
    @FXML
    void click_cell3() {
        if (game_started) move(t3, 3);
    }
    @FXML
    void click_cell4() {
        if (game_started) move(t4, 4);
    }
    @FXML
    void click_cell5() {
        if (game_started) move(t5, 5);
    }
    @FXML
    void click_cell6() {
        if (game_started) move(t6, 6);
    }
    @FXML
    void click_cell7() {
        if (game_started) move(t7, 7);
    }
    @FXML
    void click_cell8() {
        if (game_started) move(t8, 8);
    }
    @FXML
    void click_cell9() {
        if (game_started) move(t9, 9);
    }
//  0 - player move || 1 - enemy move || 2 - not move
    int checkMove(int cell_number){
        if (player_move & map.get(cell_number) >= 3) { return 0; }
        else if (map.get(cell_number) >= 3){ return 1; }
        else return 2;
    }
    void move(Text t, int cell_number){
        game_started = true;
        switch (turn){
            case (0):
                if (checkMove(cell_number) == 0) {
                    t.setText("X");
                    t.setFill(Color.RED);
                    map.put(cell_number,1);
                    player_move = false;
                    counter++;
                }
                else if (checkMove(cell_number) == 1){
                    t.setText("O");
                    t.setFill(Color.BLUE);
                    map.put(cell_number,2);
                    player_move = true;
                    counter++;
                }
                break;
            case (1):
                if (checkMove(cell_number) == 0 & player_move) {
                    t.setText("X");
                    t.setFill(Color.RED);
                    map.put(cell_number,1);
                    player_move = false;
                    counter++;
                    check_win();
                    if (game_started) {
                        paint_field(EnemyLogic.easy());
                        player_move = true;
                        counter++;
                    }
                }
                break;
            case (2):
                if (checkMove(cell_number) == 0 & player_move) {
                    t.setText("X");
                    t.setFill(Color.RED);
                    map.put(cell_number,1);
                    player_move = false;
                    counter++;
                    check_win();
                    if (game_started) {
                        paint_field(EnemyLogic.hard());
                        player_move = true;
                        counter++;
                    }
                }
                break;
        }

        check_win();
        if (!rb1.isSelected() & !rb2.isSelected() & !rb3.isSelected()) rb1.setSelected(true);
    }

    void paint_field(int cell){
        switch (cell){
            case 1:
                t1.setText("O");
                t1.setFill(Color.BLUE);
                break;
            case 2:
                t2.setText("O");
                t2.setFill(Color.BLUE);
                break;
            case 3:
                t3.setText("O");
                t3.setFill(Color.BLUE);
                break;
            case 4:
                t4.setText("O");
                t4.setFill(Color.BLUE);
                break;
            case 5:
                t5.setText("O");
                t5.setFill(Color.BLUE);
                break;
            case 6:
                t6.setText("O");
                t6.setFill(Color.BLUE);
                break;
            case 7:
                t7.setText("O");
                t7.setFill(Color.BLUE);
                break;
            case 8:
                t8.setText("O");
                t8.setFill(Color.BLUE);
                break;
            case 9:
                t9.setText("O");
                t9.setFill(Color.BLUE);
                break;
        }
    }

    void check_win(){
        pane_background = new Background(
                new BackgroundFill(Color.valueOf("#006400"),
                        new CornerRadii(10),
                        new Insets(10))
        );
        if (map.get(1).equals(map.get(2)) & map.get(1).equals(map.get(3))){
            print_winner(1, cell1, cell2, cell3);
        }
        else if (map.get(4).equals(map.get(5)) & map.get(4).equals(map.get(6))){
            print_winner(4, cell4, cell5, cell6);
        }
        else if (map.get(7).equals(map.get(8)) & map.get(7).equals(map.get(9))){
            print_winner(7, cell7, cell8, cell9);
        }
        else if (map.get(1).equals(map.get(4)) & map.get(1).equals(map.get(7))){
            print_winner(1, cell1, cell4, cell7);
        }
        else if (map.get(2).equals(map.get(5)) & map.get(2).equals(map.get(8))){
            print_winner(2, cell2, cell5, cell8);
        }
        else if (map.get(3).equals(map.get(6)) & map.get(3).equals(map.get(9))){
            print_winner(3, cell3, cell6, cell9);
        }
        else if (map.get(1).equals(map.get(5)) & map.get(1).equals(map.get(9))){
            print_winner(1, cell1, cell5, cell9);
        }
        else if (map.get(3).equals(map.get(5)) & map.get(3).equals(map.get(7))){
            print_winner(3, cell3, cell5, cell7);
        }
        else if (map.get(1) <= 2 & map.get(2) <= 2 & map.get(3) <= 2 &
                map.get(4) <= 2 & map.get(5) <= 2 & map.get(6) <= 2 &
                map.get(7) <= 2 & map.get(8) <= 2 & map.get(9) <= 2) {
            text.setText("Ничья");
            game_started = false;
            paint_field("#2F4F4F");
            counter = 0;
        }
        else if (player_move) text.setText("Ход игрока Х");
        else text.setText("Ход игрока О");
    }
    void print_winner(int number_cell, Pane first_cell, Pane second_cell, Pane third_cell){
        first_cell.setBackground(pane_background);
        second_cell.setBackground(pane_background);
        third_cell.setBackground(pane_background);
        game_started = false;
        if (map.get(first_cell) == 1) text.setText("Победа Х");
        else text.setText("Победа О");
        counter = 0;
    }
    @FXML
    void new_game() {
        App.fill_map();
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        paint_field("#FFFFFF");
        text.setText("Ход игрока Х");
        if (rb1.isSelected()) turn = 0;
        else if (rb2.isSelected()) turn = 1;
        else if (rb3.isSelected()) turn = 2;
        player_move = true;
        game_started = true;
        counter = 0;
    }
    void paint_field(String color){
        pane_background = new Background(
                new BackgroundFill(Color.valueOf(color),
                new CornerRadii(10),
                new Insets(10))
        );
        cell1.setBackground(pane_background);
        cell2.setBackground(pane_background);
        cell3.setBackground(pane_background);
        cell4.setBackground(pane_background);
        cell5.setBackground(pane_background);
        cell6.setBackground(pane_background);
        cell7.setBackground(pane_background);
        cell8.setBackground(pane_background);
        cell9.setBackground(pane_background);
    }

    @FXML
    void radio_easy() {
        if (!game_started) {
            text.setText("easy mode");
            rb1.setSelected(false);
            rb3.setSelected(false);
            turn = 1;
            game_started = true;
        } else rb2.setSelected(false);
    }

    @FXML
    void radio_hard() {
        if (!game_started) {
            text.setText("hard");
            rb1.setSelected(false);
            rb2.setSelected(false);
            turn = 2;
            game_started = true;
        } else rb3.setSelected(false);
    }

    @FXML
    void radio_two() {
        if (!game_started) {
            text.setText("two");
            rb2.setSelected(false);
            rb3.setSelected(false);
            turn = 0;
            game_started = true;
        } else rb1.setSelected(false);
    }

}