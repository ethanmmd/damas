package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ResumeControllerTest extends InteractorControllerTest {

    private ResumeController resumeController;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        this.resumeController = (ResumeController) this.interactorController;
    }

    @Override
    protected InteractorController createController() {
        return new ResumeController(this.game, this.state);
    }

    @Override
    protected void verifyVisitCall() {
        verify(this.interactorControllersVisitor, times(1)).visit(this.resumeController);
    }

    @Test
    public void testResumeControllerWhenNextIsCalledThenIsNextState() {
        this.resumeController.next();
        verify(this.state, times(1)).next();
    }

    @Test
    public void testResumeControllerWhenResetIsCalledThenGameIsResetAndStateIsNext() {
        this.resumeController.reset();
        verify(this.game, times(1)).reset();
        verify(this.state, times(1)).reset();

    }


}