import org.example.AliveCell;
import org.example.DeadCell;
import org.example.ICell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeadCellTest {

    @Test
    public void testDeadCellWithThreeNeighboursBecomesAlive() {
        DeadCell cell = new DeadCell();
        ICell nextState = cell.nextState(3);
        assertTrue(nextState instanceof AliveCell);
    }

    @Test
    public void testDeadCellWithFewerThanThreeNeighboursStaysDead() {
        DeadCell cell = new DeadCell();
        ICell nextState = cell.nextState(2);
        assertFalse(nextState instanceof AliveCell);
    }

    @Test
    public void testDeadCellWithMoreThanThreeNeighboursStaysDead() {
        DeadCell cell = new DeadCell();
        ICell nextState = cell.nextState(4);
        assertFalse(nextState instanceof AliveCell);
    }
}
