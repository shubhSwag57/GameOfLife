package org.example;

public class GridPrinter {

    public void print(GameGrid grid) {
        for (int i = 0; i < grid.rows; i++) {
            for (int j = 0; j < grid.cols; j++) {
                System.out.print(grid.cells[i][j] instanceof AliveCell?'*':'-');
            }
            System.out.println();
        }
    }
}
