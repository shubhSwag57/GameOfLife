import org.example.AliveCell;
import org.example.CellUpdater;
import org.example.GameGrid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellUpdaterTest {
    @Test
    public void testUpdateWithAllDeadCells() {
        GameGrid grid = new GameGrid(3, 3);
        CellUpdater updater = new CellUpdater();
        updater.update(grid);
        assertTrue(grid.isAllDead());
    }

    @Test
    public void testUpdateWithOneAliveCell() {
        GameGrid grid = new GameGrid(3, 3);
        grid.cells[1][1] = new AliveCell();
        CellUpdater updater = new CellUpdater();
        updater.update(grid);
        assertTrue(grid.isAllDead());
    }

    @Test
    public void testUpdateWithBlockPattern() {
        GameGrid grid = new GameGrid(4, 4);
        grid.cells[1][1] = new AliveCell();
        grid.cells[1][2] = new AliveCell();
        grid.cells[2][1] = new AliveCell();
        grid.cells[2][2] = new AliveCell();
        CellUpdater updater = new CellUpdater();
        updater.update(grid);

        assertTrue(grid.cells[1][1] instanceof AliveCell);
        assertTrue(grid.cells[1][2] instanceof AliveCell);
        assertTrue(grid.cells[2][1] instanceof AliveCell);
        assertTrue(grid.cells[2][2] instanceof AliveCell);
    }

    @Test
    public void testCountLiveNeighbours() {
        GameGrid grid = new GameGrid(3, 3);
        grid.cells[0][0] = new AliveCell();
        grid.cells[0][1] = new AliveCell();
        grid.cells[1][0] = new AliveCell();
        CellUpdater updater = new CellUpdater();

        int liveNeighbours = updater.countLiveNeighbors(grid, 1, 1);
        assertEquals(3, liveNeighbours);
    }
}
