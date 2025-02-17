import org.example.AliveCell;
import org.example.GameGrid;
import org.example.Grid;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameGridTest {
    @Test
    public void testIsAllDeadWhenAllCellsAreDead() {
        GameGrid grid = new GameGrid(3, 3);
        assertTrue(grid.isAllDead());
    }

    @Test
    public void testIsAllDeadWhenOneCellIsAlive() {
        GameGrid grid = new GameGrid(3, 3);
        grid.cells[1][1] = new AliveCell();
        assertFalse(grid.isAllDead());
    }

    @Test
    public void testIsAllDeadWhenMultipleCellsAreAlive() {
        GameGrid grid = new GameGrid(3, 3);
        grid.cells[0][0] = new AliveCell();
        grid.cells[2][2] = new AliveCell();
        assertFalse(grid.isAllDead());
    }

    @Test
    public void testIsAllDeadWithEmptyGrid() {
        GameGrid grid = new GameGrid(0, 0);
        assertTrue(grid.isAllDead());
    }



}
