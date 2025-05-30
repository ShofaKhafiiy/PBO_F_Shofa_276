package com.tebakanangka;


import javafx.scene.control.*;

public class GameController {
    private final GameEngine engine;
    private final Label feedbackLabel;
    private final Label attemptLabel;
    private final TextField inputField;
    private final Button actionButton;

    public GameController(GameEngine engine, Label feedback, Label attempt, TextField input, Button button) {
        this.engine = engine;
        this.feedbackLabel = feedback;
        this.attemptLabel = attempt;
        this.inputField = input;
        this.actionButton = button;

        setup();
    }

    private void setup() {
        actionButton.setOnAction(e -> {
            if (actionButton.getText().contains("Main Lagi")) {
                engine.resetGame();
                feedbackLabel.setText("");
                attemptLabel.setText("Jumlah percobaan: 0");
                actionButton.setText("Coba Tebak!");
                inputField.setDisable(false);
                return;
            }

            try {
                int guess = Integer.parseInt(inputField.getText());
                String result = engine.checkGuess(guess);
                feedbackLabel.setText(result);
                attemptLabel.setText("Jumlah percobaan: " + engine.getState().getAttemptCount());

                if (result.equals("Benar!")) {
                    feedbackLabel.setStyle("-fx-text-fill: green;");
                    actionButton.setText("Main Lagi");
                    inputField.setDisable(true);
                } else {
                    feedbackLabel.setStyle("-fx-text-fill: firebrick;");
                }

            } catch (NumberFormatException ex) {
                feedbackLabel.setText("⚠ Masukkan angka valid!");
                feedbackLabel.setStyle("-fx-text-fill: orange;");
            }

            inputField.clear();
        });
    }
}
