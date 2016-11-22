package com.company;

import java.util.Random;

/**
 * Created by NecroS on 11/20/2016.
 */
public class DiceHelper {
    static Random rnd = new Random();

    public static int roll6d() {
        return 1 + rnd.nextInt(5);
    }
}
