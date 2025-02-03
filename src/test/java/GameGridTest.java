import org.example.Game;
import org.example.GameGrid;
import org.example.Grid;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameGridTest {
    @Test
    public void testGridInitialization() {
        Grid grid = new GameGrid(5, 5);
        assertEquals(5, grid.getRows());
        assertEquals(5, grid.getColumns());
    }

    @Test
    public  void testGridInitialization2() {
        Grid grid = new GameGrid(10, 10);
        assertEquals(10, grid.getRows());
        assertEquals(10, grid.getColumns());
    }

    @Test
    public void testGridInitializationWithNegativeInput() {
        Grid grid = new GameGrid(-15, 15);
        assertEquals(15, grid.getRows());
        assertEquals(15, grid.getColumns());
    }
    @Test
    public void testSeeding() {
        Grid grid = new GameGrid(5, 5);
        grid.seed(0.5);

        int aliveCount = 0;
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getColumns(); j++) {
                if (grid.getCellAt(i, j).isAlive()) {
                    aliveCount++;
                }
            }
        }

        assertTrue(aliveCount > 0 && aliveCount < grid.getRows() * grid.getColumns());
    }

    @Test
    public void testGridUpdate() {
        Grid grid = new GameGrid(5, 5);
        grid.seed(1.0);

        // Update the grid
        grid.update();

        // After updating, not all cells should remain alive
        assertFalse(grid.getCellAt(2, 2).isAlive());
    }
    @Test
    public void testAllDead() {
        Grid grid = new GameGrid(5, 5);
        grid.seed(0.0);

        assertTrue(grid.isAllDead());
    }

    @Test
    public void testAllAlive() {
        Grid grid = new GameGrid(5, 5);
        grid.seed(1.0);

        assertFalse(grid.isAllDead());
    }


    @Test
    public void testCountLiveNeighbors() {
        Grid grid = new GameGrid(5, 5);
        grid.seed(0.0);

        // Set some cells to be alive
        grid.getCellAt(1, 1).setAlive(true);
        grid.getCellAt(1, 2).setAlive(true);
        grid.getCellAt(2, 1).setAlive(true);

        assertEquals(3, ((GameGrid) grid).countLiveNeighbors(2, 2));
    }

    @Test
    public void testCountLiveNeighborsAtCorners() {
        Grid grid = new GameGrid(5, 5);
        grid.seed(0.0);  // All cells are dead

        // Set some cells to be alive
        grid.getCellAt(0, 0).setAlive(true);
        grid.getCellAt(0, 1).setAlive(true);
        grid.getCellAt(1, 0).setAlive(true);

        assertEquals(2 , ((GameGrid) grid).countLiveNeighbors(0, 1));
    }



}
