import org.example.CellUpdater;
import org.example.GameOfLife;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class GameOfLifeTest {
    @Test
    public void testGameInitialization() {
        GameOfLife game = new GameOfLife(3, 3, 0.4);
        assertNotNull(game);
    }


    @Test
    public void testIsAllDeadWithEmptyGrid() {
        GameOfLife game = new GameOfLife(0, 0, 0.0);
        assertTrue(game.isAllDead());
    }

    @Test
    public void testStopWithQuitInput() {
        GameOfLife game = spy(new GameOfLife(3, 3, 0.4));
        doReturn(true).when(game).stop();
        assertTrue(game.stop());
    }

    @Test
    public void testStopWithEnterInput() {
        GameOfLife game = spy(new GameOfLife(3, 3, 0.4));
        doReturn(false).when(game).stop();
        assertFalse(game.stop());
    }
}
