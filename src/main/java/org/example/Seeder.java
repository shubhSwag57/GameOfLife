package org.example;

import java.util.Random;

public class Seeder {
    private final double seedPercentage;

    public Seeder(double seedPercentage){
        this.seedPercentage = seedPercentage;
    }

    public void seed(GameGrid grid){
        Random rand = new Random();
        for (int i = 0; i < grid.rows; i++) {
            for (int j = 0; j < grid.cols; j++) {
                grid.cells[i][j] = rand.nextDouble() < seedPercentage ? new AliveCell(): new DeadCell();
            }
        }
    }
}
