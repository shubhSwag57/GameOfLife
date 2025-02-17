package org.example;

public class CellUpdater {


    public void update(GameGrid grid){
        updater(grid);
    }

    public void updater(GameGrid grid) {
        for (int i = 0; i < grid.rows; i++) {
            for (int j = 0; j < grid.cols; j++) {
                int liveNeighbors = countLiveNeighbors(grid,i,j);
                grid.cells[i][j] = grid.cells[i][j].nextState(liveNeighbors);
            }
        }
        return;
    }

    public int countLiveNeighbors(GameGrid grid,int row, int col) {
        int[] directions = {-1, 0, 1};
        int count = 0;
        for (int dx : directions) {
            for (int dy : directions) {
                if (dx == 0 && dy == 0) continue;
                int newRow = row + dx, newCol = col + dy;
                if (newRow >= 0 && newRow < grid.rows && newCol >= 0 && newCol < grid.cols && grid.cells[newRow][newCol] instanceof AliveCell) {
                    count++;
                }
            }
        }
        return count;
    }
}
