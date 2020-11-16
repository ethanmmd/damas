package usantatecla.draughts.controllers;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

import static org.mockito.MockitoAnnotations.initMocks;

public abstract class InteractorControllerTest {

    protected InteractorController interactorController;

    @Mock
    protected InteractorControllersVisitor interactorControllersVisitor;

    @Spy
    protected Game game;

    @Spy
    protected State state;

    public void setUp() {
        initMocks(this);
        this.interactorController = this.createController();
    }

    protected abstract InteractorController createController();

    @Test(expected = AssertionError.class)
    public void testInteractorControllerWhenAcceptIsCalledWithNullInteractorVisitorThrowsAssertionError() {
        this.interactorController.accept(null);
    }

    @Test
    public void testInteractorControllerWhenAcceptIsCalledWithAValidInteractorThenVisitIsCalled() {
        this.interactorController.accept(this.interactorControllersVisitor);
        this.verifyVisitCall();
    }

    protected abstract void verifyVisitCall();
}
