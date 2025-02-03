package org.example;

public class Game {
    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public void startSimulation(double seedPercentage) {
        grid.seed(seedPercentage);
        while (!grid.isAllDead()) {
            grid.print();
            grid.update();
            try {
                Thread.sleep(500);  // Slow down the simulation to make it visible
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Simulation Ended: All cells are dead.");
    }
}

