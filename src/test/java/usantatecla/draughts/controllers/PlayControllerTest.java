package usantatecla.draughts.controllers;

import org.junit.Before;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PlayControllerTest extends InteractorControllerTest {

    private PlayController playController;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        this.playController = (PlayController) this.interactorController;
    }

    @Override
    protected InteractorController createController() {
        return new PlayController(this.game, this.state);
    }

    @Override
    protected void verifyVisitCall() {
        verify(this.interactorControllersVisitor, times(1)).visit(this.playController);

    }
}
