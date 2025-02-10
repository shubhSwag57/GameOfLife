import org.example.Game;
import org.example.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameControllerTest {

    private GameController gameController;
    private Game mockGame;

    @BeforeEach
    public void setUp() {
        // Mock the Game class
        mockGame = Mockito.mock(Game.class);
        // Initialize GameController with the mocked Game
        gameController = new GameController(mockGame);
    }

    @Test
    public void testStartGameWithAllDeadCells() {
        // Set up the mock to simulate that all cells are dead
        when(mockGame.isAllDead()).thenReturn(true);

        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Start the game
        gameController.start();

        // Verify that the game was initialized and that we checked for "all dead"
        verify(mockGame, times(1)).initialize(anyInt(), anyInt(), anyDouble());
        verify(mockGame, times(1)).isAllDead();
        verify(mockGame, never()).update();
        verify(mockGame, never()).display();

        // Check the output
        assertTrue(outContent.toString().contains("All cells are dead. Simulation ends."));
    }

}