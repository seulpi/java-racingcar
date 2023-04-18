package com.nextstep.racingcargame.core;

import java.util.Random;

public class RandomNumberZeroToNine implements MovingStrategy {

    private static final int RANDOM_BOUND = 10;
    private static final Random RANDOM = new Random();

    @Override
    public int randomNumber() {
        return RANDOM.nextInt(RANDOM_BOUND);
    }
}