package tdd.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private int baseScore = 0;
    private int bonusScore = 0;
    private List<Integer> rolls = new ArrayList<>();
    private boolean isSpare = false;

    public void roll(int pin) {
        if (isPossiblePin(pin)) {
            this.baseScore += pin;
            rolls.add(pin);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isPossiblePin(int pin) {
        return pin >= 0 && pin <= 10;
    }

    public Integer score() {
        for (int i = 0; i < rolls.size(); i++) {
            if (i < 18) {
                if (rolls.get(i) == 10) {
                    this.bonusScore += rolls.get(i + 1);
                    this.bonusScore += rolls.get(i + 2);
                } else if (rolls.get(i) + rolls.get(i + 1) == 10) {
                    this.bonusScore += rolls.get(i + 2);
                }
            }
        }
        return this.baseScore + this.bonusScore;
    }
}