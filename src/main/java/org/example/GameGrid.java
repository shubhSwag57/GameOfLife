package org.example;

import java.util.Random;

public class GameGrid implements Grid{
    final ICell[][] cells;
    final int rows;
    final int cols;

    public GameGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new ICell[rows][cols];
    }


    @Override
    public void seed(double seedPercentage) {
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = rand.nextDouble() < seedPercentage ? new Cell(true) : new Cell(false);
            }
        }
    }

    @Override
    public void update() {
        Cell[][] newCells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);
                if (cells[i][j].isAlive()) {
                    newCells[i][j] = (liveNeighbors == 2 || liveNeighbors == 3) ? new Cell(true) : new Cell(false);
                } else {
                    newCells[i][j] = (liveNeighbors == 3) ? new Cell(true) : new Cell(false);
                }
            }
        }
        this.cells = newCells;
    }

    public int countLiveNeighbors(int row, int col) {
        int[] directions = {-1, 0, 1};
        int count = 0;
        for (int dx : directions) {
            for (int dy : directions) {
                if (dx == 0 && dy == 0) continue;
                int newRow = row + dx, newCol = col + dy;
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && cells[newRow][newCol].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cells[i][j].isAlive() ? "*" : "-");
            }
            System.out.println();
        }
    }


    @Override
    public boolean isAllDead() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return cols;
    }

    @Override
    public Cell getCellAt(int row, int col) {
        return cells[row][col];
    }

}
