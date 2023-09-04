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
             if (HelloController.getMap(r) > 2) {
                 HelloController.setMap(r, o);
                 i = 1025;
             }
         }
         return r;
    }

    public static int hard(){
        int r;
        switch (HelloController.counter) {
            case 1:
                if (HelloController.getMap(5) > 3) {
                    HelloController.setMap(5, o);
                    return 5;
                }
                else if (HelloController.getMap(5) == 1) {
                    r = random.nextInt(1,4);
                    switch (r){
                        case 1: HelloController.setMap(1, o); return 1;
                        case 2: HelloController.setMap(3, o); return 3;
                        case 3: HelloController.setMap(7, o); return 7;
                        case 4: HelloController.setMap(9, o); return 9;
                    }
                }
                break;
            default: return  1;
        }
        return 1;
    }


}
