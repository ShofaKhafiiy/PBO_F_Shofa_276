package com.tebakanangka;



import java.util.Random;

public class GameEngine {
    private final Random random = new Random();
    private final GameState state;

    public GameEngine() {
        this.state = new GameState(generateNumber());
    }

    private int generateNumber() {
        return random.nextInt(100) + 1;
    }

    public String checkGuess(int guess) {
        state.incrementAttempt();
        int target = state.getTargetNumber();
        if (guess < target) return "Terlalu kecil!";
        else if (guess > target) return "Terlalu besar!";
        else return "Benar!";
    }

    public void resetGame() {
        state.setTargetNumber(generateNumber());
        state.reset();
    }

    public GameState getState() {
        return state;
    }
}
