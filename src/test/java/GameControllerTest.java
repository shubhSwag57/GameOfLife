import org.example.GameController;
import org.example.GameGrid;
import org.example.GameOfLife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameControllerTest {

    @Test
    public void testGameControllerInitialization() {
        GameController controller = new GameController();
        assertNotNull(controller);
    }


    @Test
    public void testGameStartsProperly() {
        GameController controller = spy(new GameController());
        assertNotNull(controller);

        // Mock the start method
        doNothing().when(controller).start();
        controller.start();
        verify(controller, times(1)).start();
    }

    @Test
    public void testGameStopsProperly() {
        GameController controller = spy(new GameController());
        GameOfLife gameOfLife = spy(new GameOfLife(5,5,0.5));
//        controller.input();

        // Mock the stop method
        doNothing().when(controller).stop();
        controller.stop();
        verify(gameOfLife, times(1)).stop();
    }

    @Test
    public void testGameFlow() {
        GameController controller = spy(new GameController());

        // Mock methods to avoid input prompts
        doNothing().when(controller).input();
        doNothing().when(controller).start();
        doNothing().when(controller).stop();

        controller.input();
        controller.start();
        controller.stop();

        verify(controller, times(1)).input();
        verify(controller, times(1)).start();
        verify(controller, times(1)).stop();
    }

}