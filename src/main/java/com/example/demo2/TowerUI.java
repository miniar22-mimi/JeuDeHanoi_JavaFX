package com.example.demo2;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import java.util.List;

public class TowerUI extends StackPane {
    private final int towerId; // Identifiant numérique
    private final Rectangle pole;
    private final Rectangle base;

    public TowerUI(int id) {
        this.towerId = id;
        this.setId("tower-" + id); // ID CSS (String)

        // Configuration du pilier
        pole = new Rectangle(20, 300);
        pole.setStyle("-fx-fill: linear-gradient(to bottom, #8B4513, #A0522D);");

        // Configuration de la base
        base = new Rectangle(200, 20);
        base.setStyle("-fx-fill: #A0522D;");
        base.setTranslateY(160);

        this.getChildren().addAll(base, pole);
        this.setPrefSize(200, 400);
    }

    // Méthode renommée pour éviter le conflit
    public int getTowerId() {
        return towerId;
    }

    public void updateDiscs(List<Integer> discSizes) {
        this.getChildren().removeIf(node -> node instanceof DiscUI);

        double baseY = 140;
        double spacing = 25;

        for (int i = 0; i < discSizes.size(); i++) {
            DiscUI disc = new DiscUI(discSizes.get(i));
            disc.setTranslateY(baseY - (i * spacing));
            this.getChildren().add(disc);
        }
    }

    public void highlight() {
        base.setStyle("-fx-fill: #CD8500;");
    }

    public void unhighlight() {
        base.setStyle("-fx-fill: #A0522D;");
    }
}