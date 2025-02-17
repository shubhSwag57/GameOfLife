import org.example.AliveCell;
import org.example.ICell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AliveCellTest {
    @Test
    public void testAliveCellWithFewerThanTwoNeighboursDies() {
        AliveCell cell = new AliveCell();
        ICell nextState = cell.nextState(1);
        assertFalse(nextState instanceof AliveCell);
    }

    @Test
    public void testAliveCellWithTwoNeighboursStaysAlive() {
        AliveCell cell = new AliveCell();
        ICell nextState = cell.nextState(2);
        assertTrue(nextState instanceof AliveCell);
    }

    @Test
    public void testAliveCellWithThreeNeighboursStaysAlive() {
        AliveCell cell = new AliveCell();
        ICell nextState = cell.nextState(3);
        assertTrue(nextState instanceof AliveCell);
    }

    @Test
    public void testAliveCellWithMoreThanThreeNeighboursDies() {
        AliveCell cell = new AliveCell();
        ICell nextState = cell.nextState(4);
        assertFalse(nextState instanceof AliveCell);
    }
}
