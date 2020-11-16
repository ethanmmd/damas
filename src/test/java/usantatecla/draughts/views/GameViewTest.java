package usantatecla.draughts.views;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.out;
import static java.lang.System.setOut;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.MockitoAnnotations.initMocks;

public class GameViewTest {

    private final PrintStream standardOut = out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private InteractorController interactorController;
    private GameView gameView;

    @Before
    public void setUp() {
        initMocks(this);
        this.gameView = new GameView();
        this.interactorController = spy(new StartController(new Game(), new State()));
        setOut(new PrintStream(this.outputStreamCaptor));
    }

    @After
    public void tearDown() {
        setOut(this.standardOut);
    }

    @Test(expected = AssertionError.class)
    public void testGameViewWhenControllerIsNull() {
        gameView.write(null);
    }

    @Test
    public void testGameViewWhenWriteWithNonNullControllerThenDisplayBoard() {
        this.gameView.write(this.interactorController);
        String board =
                " 12345678\n" +
                        "1 n n n n1\n" +
                        "2n n n n 2\n" +
                        "3 n n n n3\n" +
                        "4        4\n" +
                        "5        5\n" +
                        "6b b b b 6\n" +
                        "7 b b b b7\n" +
                        "8b b b b 8\n" +
                        " 12345678\n";

        assertEquals(board, outputStreamCaptor.toString());


    }
}