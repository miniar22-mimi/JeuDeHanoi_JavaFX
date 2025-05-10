package com.example.demo2;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Disk> disks = new ArrayList<>();

    // Méthode manquante
    public List<Integer> getDiscSizes() {
        List<Integer> sizes = new ArrayList<>();
        for (Disk disk : disks) {
            sizes.add(disk.getSize());
        }
        return sizes;
    }

    public void push(Disk disk) {
        disks.add(disk);
    }

    public Disk pop() {
        return disks.remove(disks.size() - 1);
    }

    public Disk peek() {
        return disks.get(disks.size() - 1);
    }

    public boolean isEmpty() {
        return disks.isEmpty();
    }

    public List<Disk> getDisks() {
        return disks;
    }
}