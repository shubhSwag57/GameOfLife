import org.example.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameControllerTest {

    private GameController gameController;
    private Game mockGame;


    @BeforeEach
    public void setUp() {
        // Mock the Game and Grid classes
        mockGame = Mockito.mock(Game.class);


        gameController = new GameController(mockGame);
    }

    @Test
    public void testInput() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextInt()).thenReturn(5, 5);
        when(scanner.nextDouble()).thenReturn(0.5);

        gameController.input();

        verify(mockGame).initialize(5, 5, 0.5);
    }


//    @Test
//    public void testStartGameWhenAllCellsAreDead() {
//        when(mockGame.isAllDead()).thenReturn(true);
//
//        gameController.start();
//
//        verify(mockGame, times(1)).initialize(anyInt(), anyInt(), anyDouble());
//
//        // Verify that the game is not updated or displayed
//        verify(mockGame, never()).update();
//        verify(mockGame, never()).display();
//    }

}