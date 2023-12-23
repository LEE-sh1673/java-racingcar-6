package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private static final int MOVABLE_NUMBER = 4;

    @Override
    public boolean movable() {
        return pickNumber() >= MOVABLE_NUMBER;
    }

    private int pickNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
