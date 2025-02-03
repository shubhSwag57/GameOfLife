import org.example.GameGrid;
import org.example.Grid;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameGridTest {
    @Test
    public void testGridInitialization() {
        Grid grid = new GameGrid(5, 5);
        assertEquals(5, grid.getRows());
        assertEquals(5, grid.getColumns());
    }
}
