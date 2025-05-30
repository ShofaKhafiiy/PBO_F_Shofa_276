package com.tebakanangka;

public class GameState {
    private int targetNumber;
    private int attemptCount;

    public GameState(int targetNumber) {
        this.targetNumber = targetNumber;
        this.attemptCount = 0;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
        this.attemptCount = 0;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void incrementAttempt() {
        this.attemptCount++;
    }

    public void reset() {
        this.attemptCount = 0;
    }
}
