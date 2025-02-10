package org.example;

public class Game {
    private Grid grid;
    public Game(Grid grid) {
        this.grid = grid;
    }

//    public void start(double seedPercentage) {
//        grid.seed(seedPercentage);
//        while (!grid.isAllDead()) {
//            grid.print();
//            grid.update();
//            try {
//                Thread.sleep(1000);  // Slow down the simulation to make it visible
//            } catch (InterruptedException e) {
//                System.out.println("Simulation Interrupted: Ending the game.");
//                e.printStackTrace();
//            }
//        }
//        System.out.println("Simulation Ended: All cells are dead.");
//    }

    public void initialize(int rows, int cols, double seedPercentage) {
        this.grid = new GameGrid(rows, cols);
        this.grid.seed(seedPercentage);
    }

    // Update the game state (the grid) for the next generation
    public void update() {
        grid.update();
    }

    // Display the current state of the grid
    public void display() {
        grid.print();
    }

    // Check if all cells are dead
    public boolean isAllDead() {
        return grid.isAllDead();
    }

    public Grid getGrid() {
        return grid;
    }
}

