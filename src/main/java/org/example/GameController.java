package org.example;


import java.util.Scanner;

public class GameController {
    // input
    // stop
    // start
    // update game of game by it'self.

    private  GameOfLife game;

    public GameController() {
        this.game = null;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows for the grid:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of columns for the grid:");
        int cols = scanner.nextInt();

        System.out.println("Enter the seed percentage (0.0 to 1.0):");
        double seedPercentage = scanner.nextDouble();
        this.game = new GameOfLife(rows,cols,seedPercentage);
        System.out.println("Game started. Press q to stop.");
    }

    public void start() {
        game.start();
    }

    public void stop() {
        game.stop();
    }
}