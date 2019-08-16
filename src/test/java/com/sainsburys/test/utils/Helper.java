package com.sainsburys.test.utils;

import java.util.Random;

public class Helper {

    public int randomNumberGenerator(int size){
        Random random=new Random();
        return random.nextInt(size-1);
    }
}
