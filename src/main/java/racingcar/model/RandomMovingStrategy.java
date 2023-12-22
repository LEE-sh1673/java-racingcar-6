package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 9;
    private static final int THRESHOLD = 4;

    @Override
    public boolean movable() {
        return pickNumber() >= THRESHOLD;
    }

    private int pickNumber() {
        return Randoms.pickNumberInRange(MIN_SPEED, MAX_SPEED);
    }
}
