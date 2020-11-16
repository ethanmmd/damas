package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StartControllerTest extends InteractorControllerTest {

    private StartController startController;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        this.startController = (StartController) this.interactorController;
    }

    @Override
    protected InteractorController createController() {
        return new StartController(this.game, this.state);
    }

    @Override
    protected void verifyVisitCall() {
        verify(this.interactorControllersVisitor, times(1)).visit(this.startController);
    }

    @Test
    public void testStartControllerWhenStartIsCalledThenNextStateIsCalled() {
        this.startController.start();
        verify(this.state, times(1)).next();
    }
}