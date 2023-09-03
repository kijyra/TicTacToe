package com.example.demo1;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Button button_new_game;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
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


    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private Boolean player_move = true;
    public static void setMap(int position, int value){
        map.put(position,value);
    }
    BackgroundFill fill;
    Background pane_background;

    private ToggleGroup group = new ToggleGroup();
    @FXML
    void click_cell1(MouseEvent event) {
        move(t1, 1);
    }
    @FXML
    void click_cell2(MouseEvent event) {
        move(t2, 2);
    }
    @FXML
    void click_cell3(MouseEvent event) {
        move(t3, 3);
    }
    @FXML
    void click_cell4(MouseEvent event) {
        move(t4, 4);
    }
    @FXML
    void click_cell5(MouseEvent event) {
        move(t5, 5);
    }
    @FXML
    void click_cell6(MouseEvent event) {
        move(t6, 6);
    }
    @FXML
    void click_cell7(MouseEvent event) {
        move(t7, 7);
    }
    @FXML
    void click_cell8(MouseEvent event) {
        move(t8, 8);
    }
    @FXML
    void click_cell9(MouseEvent event) {
        move(t9, 9);
    }
//  0 - player move || 1 - enemy move || 2 - not move
    int checkMove(int cell_number){
        if (player_move & map.get(cell_number) >= 3) { return 0; }
        else if (map.get(cell_number) >= 3){ return 1; }
        else return 2;
    }
    void move(Text t, int cell_number){
        if (checkMove(cell_number) == 0) {
            t.setText("X");
            t.setFill(Color.RED);
            map.put(cell_number,1);
            player_move = false;
        }
        else if (checkMove(cell_number) == 1){
            t.setText("O");
            t.setFill(Color.BLUE);
            map.put(cell_number,2);
            player_move = true;
        }
        check_win();
        if (!rb1.isSelected() & !rb2.isSelected() & !rb3.isSelected()) rb1.setSelected(true);
    }
    void check_win(){
        pane_background = new Background(
                new BackgroundFill(Color.valueOf("#006400"),
                        new CornerRadii(10),
                        new Insets(10))
        );
        if (map.get(1) == map.get(2) & map.get(1) == map.get(3))
        {
            cell1.setBackground(pane_background);
            cell2.setBackground(pane_background);
            cell3.setBackground(pane_background);
            if (map.get(1) == 1) text.setText("X WON");
            else text.setText("O WON");
        }
        else if (map.get(4) == map.get(5) & map.get(4) == map.get(6))        {
            cell4.setBackground(pane_background);
            cell5.setBackground(pane_background);
            cell6.setBackground(pane_background);
            if (map.get(4) == 1) text.setText("X WON");
            else text.setText("O WON");
        }
        else if (map.get(7) == map.get(8) & map.get(7) == map.get(9)){
            cell7.setBackground(pane_background);
            cell8.setBackground(pane_background);
            cell9.setBackground(pane_background);
            if (map.get(7) == 1) text.setText("X WON");
            else text.setText("O WON");
        }
        else if (map.get(1) == map.get(4) & map.get(1) == map.get(7)){
            cell7.setBackground(pane_background);
            cell1.setBackground(pane_background);
            cell4.setBackground(pane_background);
            if (map.get(7) == 1) text.setText("X WON");
            else text.setText("O WON");
        }
        else if (map.get(2) == map.get(5) & map.get(2) == map.get(8)){
            cell2.setBackground(pane_background);
            cell5.setBackground(pane_background);
            cell8.setBackground(pane_background);
            if (map.get(2) == 1) text.setText("X WON");
            else text.setText("O WON");
        }
        else if (map.get(3) == map.get(6) & map.get(3) == map.get(9)){
            cell3.setBackground(pane_background);
            cell6.setBackground(pane_background);
            cell9.setBackground(pane_background);
            if (map.get(2) == 1) text.setText("X WON");
            else text.setText("O WON");
        }
        else if (map.get(1) == map.get(5) & map.get(1) == map.get(9)){
            cell1.setBackground(pane_background);
            cell5.setBackground(pane_background);
            cell9.setBackground(pane_background);
            if (map.get(1) == 1) text.setText("X WON");
            else text.setText("O WON");
        }
        else if (map.get(3) == map.get(5) & map.get(3) == map.get(7)){
            cell3.setBackground(pane_background);
            cell5.setBackground(pane_background);
            cell7.setBackground(pane_background);
            if (map.get(3) == 1) text.setText("X победил");
            else text.setText("O победил");
        }
        else if (map.get(1) <= 2 & map.get(2) <= 2 & map.get(3) <= 2 &
                map.get(4) <= 2 & map.get(5) <= 2 & map.get(6) <= 2 &
                map.get(7) <= 2 & map.get(8) <= 2 & map.get(9) <= 2) {
            text.setText("Ничья");
            paint_field("#2F4F4F");
        }
        else if (player_move) text.setText("Ход игрока Х");
        else text.setText("Ход игрока О");
    }
    @FXML
    void new_game(ActionEvent event) {
        HelloApplication.fill_map();
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
    void radio_easy(ActionEvent event) {
        text.setText("easy");
        rb1.setSelected(false);
        rb3.setSelected(false);
    }

    @FXML
    void radio_hard(ActionEvent event) {
        text.setText("hard");
        rb1.setSelected(false);
        rb2.setSelected(false);
    }

    @FXML
    void radio_two(ActionEvent event) {
        text.setText("two");
        rb2.setSelected(false);
        rb3.setSelected(false);
    }

}