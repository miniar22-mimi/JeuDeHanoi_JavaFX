package com.example.demo2;

public class Disk {
    private final int size;

    public Disk(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Disk[" + size + "]";
    }
}