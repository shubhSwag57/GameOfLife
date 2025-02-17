package org.example;

import java.util.Random;

public class GameGrid implements Grid{
    public ICell[][] cells;
    final int rows;
    final int cols;

    public GameGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new ICell[rows][cols];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new DeadCell();
            }
        }
    }




    @Override
    public boolean isAllDead() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j] instanceof  AliveCell) {
                    return false;
                }
            }
        }
        return true;
    }

}
