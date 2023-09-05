package com.example.demo1;

import java.util.HashMap;
import java.util.Random;

public class EnemyLogic {
    private static int o = 2, r, returned;
    static Random random = new Random();
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int easy(){
         int i;
         for (i = 1; i <= 1024; i++) {
             r = random.nextInt(1, 9);
             if (Controller.getMap(r) > 2) {
                 Controller.setMap(r, o);
                 i = 1025;
             }
         }
         return r;
    }

    static boolean isEmpty(int cell){
        if (Controller.getMap(cell) >= 3)return true;
        else return false;
    }
    static boolean isPlayer(int cell1, int cell2, int cell3){
        if (Controller.getMap(cell1) == 1 & Controller.getMap(cell2) == 1 & !(Controller.getMap(cell3) == 2)) return true;
        else return false;
    }
    static boolean isEnemy(int cell1, int cell2, int cell3){
        if (Controller.getMap(cell1) == 2 & Controller.getMap(cell2) == 2 & !(Controller.getMap(cell3) == 1)) return true;
        else return false;
    }
    static void move(int cell){
        Controller.setMap(cell,o);
    }
    public static int hard(){
        System.out.println(Controller.counter);
        switch (Controller.counter) {
            case 1:
                if (isEmpty(5)) { move(5); returned = 5; }
                else {
                    r = random.nextInt(1,4);
                    switch (r){
                        case 1: move(1); returned = 1; break;
                        case 2: move(3); returned = 3; break;
                        case 3: move(7); returned = 7; break;
                        case 4: move(9); returned = 9; break;
                    }
                }
                break;
            case 3, 5, 7:
//                                  1 * *   * 2 *   * * 3   4 * *   * * 5   6 6 6   * * *   * * *
//                                  1 * *   * 2 *   * * 3   * 4 *   * 5 *   * * *   7 7 7   * * *
//                                  1 * *   * 2 *   * * 3   * * 4   5 * *   * * *   * * *   8 8 8
                    // 1
                    if (isEnemy(1, 4, 7)) { move(7); returned = 7; }
                    else if (isEnemy(1, 7, 4)) { move(4); returned = 4; }
                    else if (isEnemy(4, 7, 1)) { move(1); returned = 1; }
                    //2
                    else if (isEnemy(2, 5, 8)) { move(8); returned = 8; }
                    else if (isEnemy(5, 8, 2)) { move(2); returned = 2; }
                    //3
                    else if (isEnemy(3, 6, 9)) { move(9); returned = 9; }
                    else if (isEnemy(9, 6, 3)) { move(3); returned = 3; }
                    else if (isEnemy(3, 9, 6)) { move(6); returned = 6; }
                    //4
                    else if (isEnemy(1, 5, 9)) { move(9); returned = 9; }
                    else if (isEnemy(5, 9, 1)) { move(1); returned = 1; }
                    //5
                    else if (isEnemy(3, 5, 7)) { move(7); returned = 7; }
                    else if (isEnemy(5, 7, 3)) { move(3); returned = 3; }
                    //6
                    else if (isEnemy(1, 2, 3)) { move(3); returned = 3; }
                    else if (isEnemy(1, 3, 2)) { move(2); returned = 2; }
                    else if (isEnemy(3, 2, 1)) { move(1); returned = 1; }
                    //7
                    else if (isEnemy(4, 5, 6)) { move(6); returned = 6; }
                    else if (isEnemy(6, 5, 4)) { move(4); returned = 4; }
                    //8
                    else if (isEnemy(7, 8, 9)) { move(9); returned = 9; }
                    else if (isEnemy(7, 9, 8)) { move(8); returned = 8; }
                    else if (isEnemy(8, 9, 7)) { move(7); returned = 7; }
                    //1
                    else if (isPlayer(1, 4, 7)) { move(7); returned = 7; }
                    else if (isPlayer(1, 7, 4)) { move(4); returned = 4; }
                    else if (isPlayer(4, 7, 1)) { move(1); returned = 1; }
                    //2
                    else if (isPlayer(2, 5, 8)) { move(8); returned = 8; }
                    else if (isPlayer(5, 8, 2)) { move(2); returned = 2; }
                    //3
                    else if (isPlayer(3, 6, 9)) { move(9); returned = 9; }
                    else if (isPlayer(9, 6, 3)) { move(3); returned = 3; }
                    else if (isPlayer(3, 9, 6)) { move(6); returned = 6; }
                    //4
                    else if (isPlayer(1, 5, 9)) { move(9); returned = 9; }
                    else if (isPlayer(5, 9, 1)) { move(1); returned = 1; }
                    //5
                    else if (isPlayer(3, 5, 7)) { move(7); returned = 7; }
                    else if (isPlayer(5, 7, 3)) { move(3); returned = 3; }
                    //6
                    else if (isPlayer(1, 2, 3)) { move(3); returned = 3; }
                    else if (isPlayer(1, 3, 2)) { move(2); returned = 2; }
                    else if (isPlayer(3, 2, 1)) { move(1); returned = 1; }
                    //7
                    else if (isPlayer(4, 5, 6)) { move(6); returned = 6; }
                    else if (isPlayer(6, 5, 4)) { move(4); returned = 4; }
                    //8
                    else if (isPlayer(7, 8, 9)) { move(9); returned = 9; }
                    else if (isPlayer(7, 9, 8)) { move(8); returned = 8; }
                    else if (isPlayer(8, 9, 7)) { move(7); returned = 7; }
                    else returned = easy();
                break;
        }
        System.out.println(Controller.getMap(1) + "||" + Controller.getMap(2) + "||" +  Controller.getMap(3));
        System.out.println(Controller.getMap(4) + "||" + Controller.getMap(5) + "||" +  Controller.getMap(6));
        System.out.println(Controller.getMap(7) + "||" + Controller.getMap(8) + "||" +  Controller.getMap(9));
        System.out.println("Ход в ячейку " + returned);
        return returned;
    }

}
