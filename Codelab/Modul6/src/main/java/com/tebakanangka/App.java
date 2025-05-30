package com.tebakanangka;


import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        GameUI ui = new GameUI();
        stage.setScene(ui.createScene());
        stage.setTitle("Tebak Angka Advance");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
