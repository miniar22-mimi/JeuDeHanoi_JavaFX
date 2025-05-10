package com.example.demo2;

import java.util.List;
import java.util.ArrayList;

public class GameLogic {
    private Tower[] towers;
    private int numDisks;
    private Player player;
    private int moveCount = 0;

    public GameLogic(int numDisks, Player player) {
        this.numDisks = numDisks;
        this.player = player;
        this.towers = new Tower[3];

        // Initialisation des tours
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower();
        }

        // Ajout des disques sur la première tour
        for (int i = numDisks; i > 0; i--) {
            towers[0].push(new Disk(i));
        }
    }

    public boolean moveDisk(int from, int to) {
        if (from < 0 || from >= 3 || to < 0 || to >= 3 || from == to) {
            return false;
        }

        Tower source = towers[from];
        Tower destination = towers[to];

        if (source.isEmpty()) {
            return false;
        }

        Disk diskToMove = source.pop();
        if (!destination.isEmpty() && destination.peek().getSize() < diskToMove.getSize()) {
            source.push(diskToMove);
            return false;
        }

        destination.push(diskToMove);
        moveCount++; // Incrémenter le compteur de coups
        return true;
    }

    public boolean isGameOver() {
        return towers[2].getDisks().size() == numDisks;
    }

    // Méthodes d'accès
    public Player getPlayer() {
        return this.player;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public List<Integer> getTowerState(int towerIndex) {
        return towers[towerIndex].getDiscSizes();
    }

    public Tower[] getTowers() {
        return this.towers;
    }

    // Méthode de résolution automatique (optionnelle)
    public void solve(int n, int from, int aux, int to) {
        if (n == 1) {
            moveDisk(from, to);
            return;
        }
        solve(n - 1, from, to, aux);
        moveDisk(from, to);
        solve(n - 1, aux, from, to);
    }

    // Méthode d'affichage console (debug)
    public void render() {
        System.out.println("----- État des tours -----");
        for (int i = 0; i < 3; i++) {
            System.out.print("Tour " + (i + 1) + ": ");
            for (Disk disk : towers[i].getDisks()) {
                System.out.print(disk.getSize() + " ");
            }
            System.out.println();
        }
    }
}