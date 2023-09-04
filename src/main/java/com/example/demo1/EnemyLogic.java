package com.example.demo1;

import java.util.HashMap;
import java.util.Random;

public class EnemyLogic {
    private static int o = 2;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int easy(){
        int i, r;
        Random random = new Random();
        r = random.nextInt(1, 9);
        for (i = 1; i <= 9; i++){
            if (HelloController.getMap(i) > 2) {
                random.nextInt(1, 9);
                HelloController.setMap(r, o);
            }
        }
        return r;
    }

    public static int hard(){
        HelloController.setMap(1, o);
        return 1;
    }


}
