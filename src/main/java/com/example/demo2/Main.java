package com.example.demo2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private GameLogic game;
    private HanoiUI gameUI;

    @Override
    public void start(Stage primaryStage) {
        gameUI = new HanoiUI();
        gameUI.initializeGameScreen(this::startGame);
    }

    private void startGame(String playerName, int numDisks) {
        Player player = new Player(playerName);
        game = new GameLogic(numDisks, player);
        gameUI.createGameInterface(game);
    }

    public static void main(String[] args) {
        launch(args);
    }
}