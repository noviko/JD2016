package by.it.podelstchikova.jd02_01.utils;

import java.util.Random;

public class Helper {

    public static int getRandomIntegerInRange(int min, int max){
        Random rand = new Random();
        int randInt = rand.nextInt((max - min) + 1) + min;

        return randInt;
    }
}
