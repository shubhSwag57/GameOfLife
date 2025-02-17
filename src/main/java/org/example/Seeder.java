package org.example;

import java.util.Random;

public class Seeder {
    private final int seedPercentage;

    public Seeder(int seedPercentage){
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
