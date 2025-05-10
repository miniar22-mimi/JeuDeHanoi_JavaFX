package com.example.demo2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HanoiUI {
    private Stage primaryStage;
    private GameLogic game;
    private TowerUI[] towers;
    private TowerUI selectedTower = null;

    public void initializeGameScreen(StartHandler startHandler) {
        Stage inputStage = new Stage();
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        TextField nameField = new TextField();
        nameField.setPromptText("Entrez votre nom");
        Spinner<Integer> diskSpinner = new Spinner<>(3, 8, 5);
        Button startButton = new Button("Commencer");

        startButton.setOnAction(e -> {
            if (!nameField.getText().isEmpty()) {
                startHandler.handle(nameField.getText(), diskSpinner.getValue());
                inputStage.close();
            }
        });

        root.getChildren().addAll(
                new Label("Nom du joueur:"),
                nameField,
                new Label("Nombre de disques:"),
                diskSpinner,
                startButton
        );

        Scene scene = new Scene(root, 300, 250);
        inputStage.setScene(scene);
        inputStage.setTitle("Configuration de la partie");
        inputStage.show();
    }

    public void createGameInterface(GameLogic game) {
        this.game = game;
        primaryStage = new Stage();
        HBox root = new HBox(50);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #F5F5F5;");

        towers = new TowerUI[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new TowerUI(i);
            setupTowerInteraction(towers[i]);
            root.getChildren().add(towers[i]);
        }

        updateTowers();

        String playerName = (game != null && game.getPlayer() != null)
                ? game.getPlayer().getName()
                : "Joueur inconnu";
        primaryStage.setTitle("Tours de Hanoi - " + playerName);

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupTowerInteraction(TowerUI tower) {
        tower.setOnMouseClicked(e -> handleTowerClick(tower));
    }

    private void handleTowerClick(TowerUI clickedTower) {
        if (selectedTower == null) {
            selectedTower = clickedTower;
            clickedTower.highlight();
        } else {
            selectedTower.unhighlight();
            game.moveDisk(selectedTower.getTowerId(), clickedTower.getTowerId()); // Utilisation de getTowerId()
            updateTowers();
            selectedTower = null;

            if (game.isGameOver()) {
                showGameOver();
            }
        }
    }

    private void updateTowers() {
        for (int i = 0; i < 3; i++) {
            towers[i].updateDiscs(game.getTowerState(i));
        }
    }

    private void showGameOver() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Partie terminée");
        alert.setHeaderText("Félicitations " + game.getPlayer().getName() + " !");
        alert.setContentText("Nombre de coups : " + game.getMoveCount());
        alert.showAndWait();
    }
}