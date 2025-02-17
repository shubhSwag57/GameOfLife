package org.example;

import java.util.Scanner;

public class GameOfLife {
    private GameGrid grid;
    private Seeder seeder;
    private CellUpdater cellUpdater;
    private GridPrinter gridPrinter;

    public GameOfLife(int rows,int cols,double seedPercentage){
        this.grid = new GameGrid(rows,cols);
        this.seeder = new Seeder(seedPercentage);
        seeder.seed(grid);
        this.cellUpdater = new CellUpdater();
        this.gridPrinter = new GridPrinter();
    }

    public void start(){
        // Start the game loop
        while (!isAllDead()) {
            gridPrinter.print(grid);
            cellUpdater.update(grid);
            if(!stop()){
                break;
            }
        }

        if (isAllDead()) {
            System.out.println("All cells are dead. Simulation ends.");
        }
    }

    public boolean isAllDead(){
        return grid.isAllDead();
    }

    public boolean stop(){
        System.out.println("Press Enter to Continue or type q to quit the game");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return !input.equalsIgnoreCase("q");
    }

}
