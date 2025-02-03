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
        grid.seed(1.0);  // All cells are alive

        // Update the grid
        grid.update();

        // After updating, not all cells should remain alive
        assertFalse(grid.getCellAt(2, 2).isAlive());
    }
}
