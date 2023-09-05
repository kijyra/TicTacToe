package com.example.demo1;

import java.util.HashMap;
import java.util.Random;

public class EnemyLogic {
    private static int o = 2;
    static Random random = new Random();
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int easy(){
         int i, r = 0;
         for (i = 1; i <= 1024; i++) {
             r = random.nextInt(1, 9);
             if (Controller.getMap(r) > 2) {
                 Controller.setMap(r, o);
                 i = 1025;
             }
         }
         return r;
    }

    public static int hard(){
        int r; System.out.println(Controller.counter);
        switch (Controller.counter) {
            case 1:
                if (Controller.getMap(5) > 3) {
                    Controller.setMap(5, o);
                    return 5;
                }
                else if (Controller.getMap(5) == 1) {
                    r = random.nextInt(1,4);
                    switch (r){
                        case 1: Controller.setMap(1, o); return 1;
                        case 2: Controller.setMap(3, o); return 3;
                        case 3: Controller.setMap(7, o); return 7;
                        case 4: Controller.setMap(9, o); return 9;
                    }
                }
                break;
            case 3:

            case 5:

            case 7:

            case 9:

            default: return  1;
        }
        return 1;
    }


}
