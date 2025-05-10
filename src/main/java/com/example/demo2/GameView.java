package com.example.demo2;

import java.util.Scanner;

public class GameView {
    private Scanner scanner;

    public GameView() {
        this.scanner = new Scanner(System.in);
    }

    public int askForNumberOfDisks() {
        System.out.print("Entrez le nombre de disques (3, 4, 6) : ");
        return scanner.nextInt();
    }

    public String askForPlayerName() {
        System.out.print("Entrez votre nom : ");
        return scanner.next();
    }

    public int askForMove() {
        System.out.print("Entrez votre mouvement (de la tour à la tour) : ");
        return scanner.nextInt();
    }

    public void displayGameOver() {
        System.out.println("Félicitations! Vous avez gagné !");
    }
}
