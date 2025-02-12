package org.example;


import java.util.Scanner;

public class GameController {

    private final Game game;
    private boolean isRunning;

    public GameController(Game game) {
        this.game = game;
        this.isRunning = false;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows for the grid:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of columns for the grid:");
        int cols = scanner.nextInt();

        System.out.println("Enter the seed percentage (0.0 to 1.0):");
        double seedPercentage = scanner.nextDouble();

        System.out.println("Game started. Press Enter to stop.");
        game.initialize(rows, cols, seedPercentage);
    }

    public void start() {

        System.out.println("Game started. Press Enter to stop.");
        // Start the game loop
        isRunning = true;
        while (isRunning && !game.isAllDead()) {
            game.update();
            game.display();
            try {
                Thread.sleep(500);  // Slow down the simulation for readability
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (game.isAllDead()) {
            System.out.println("All cells are dead. Simulation ends.");
        }
    }

    public void stop() {
        isRunning = false;
    }
}