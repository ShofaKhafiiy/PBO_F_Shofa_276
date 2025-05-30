package com.tebakanangka;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class GameUI {
    public Scene createScene() {
        Label title = new Label("🔁 Tebak Angka 1–100");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
        title.setTextFill(javafx.scene.paint.Color.DARKBLUE);

        Label feedback = new Label("");
        feedback.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        TextField input = new TextField();
        input.setPromptText("Masukkan tebakan...");
        input.setMaxWidth(150);

        Button guessButton = new Button("Coba Tebak!");
        guessButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        HBox inputRow = new HBox(10, input, guessButton);
        inputRow.setAlignment(Pos.CENTER);

        Label attempt = new Label("Jumlah percobaan: 0");
        attempt.setFont(Font.font("Arial", 12));

        VBox layout = new VBox(20, title, feedback, inputRow, attempt);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #EAF6FF; -fx-padding: 30;");

        // Controller link
        GameEngine engine = new GameEngine();
        new GameController(engine, feedback, attempt, input, guessButton);

        return new Scene(layout, 400, 300);
    }
}
