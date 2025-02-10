package org.example;

public class Game {
    private Grid grid;
    public Game(Grid grid) {
        this.grid = grid;
    }

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

