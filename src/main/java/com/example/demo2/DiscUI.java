package com.example.demo2;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DiscUI extends StackPane {
    public DiscUI(int size) {
        Rectangle rect = new Rectangle(40 + size * 25, 20);
        rect.setFill(Color.hsb(240 - (size * 15), 0.8, 0.8));
        rect.setStroke(Color.BLACK);
        rect.setArcWidth(10);
        rect.setArcHeight(10);

        this.getChildren().add(rect);
    }
}