package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by vsevolodvisnevskij on 24.04.17.
 */
public class Helper {
    private final static SecureRandom random = new SecureRandom();
    public static String generateRandomString() {
        BigInteger bigInteger = new BigInteger(130, random);
        return bigInteger.toString(32);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}
