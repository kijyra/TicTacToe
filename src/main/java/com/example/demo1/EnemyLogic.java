package com.example.demo1;

import java.util.HashMap;
import java.util.Random;

public class EnemyLogic {
    private static int o = 2;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int easy(){
         int i, r = 0;
         Random random = new Random();
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
        HelloController.setMap(1, o);
        return 1;
    }


}
