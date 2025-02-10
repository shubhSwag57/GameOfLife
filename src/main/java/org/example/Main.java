package org.example;

public class Main {
    public static void main(String[] args) {
        int rows = 10;
        int cols = 10;
        double seedPercentage = 0.3;  // 30% alive cells

        Grid grid = new GameGrid(rows, cols);
        Game game = new Game(grid);
        GameController controller = new GameController(game);
        controller.start();

    }
}
