package com.nike.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();

    private RandomNumberGenerator() {
    }

    public static int generateRandomNumber(int minValue, int maxValue) {
        if (minValue >= maxValue) {
            throw new IllegalArgumentException("Min value have to be less than max value");
        }
        return random.nextInt((maxValue - minValue) + 1) + minValue;
    }

}
