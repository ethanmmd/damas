package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CancelControllerTest {

    @InjectMocks
    private CancelController cancelController;

    @Mock
    private Game game;

    @Mock
    private State state;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCancelControllerWhenIsCanceledThenGameIsCanceledAndNextStateIsCalled() {
        this.cancelController.cancel();
        verify(this.game, times(1)).cancel();
        verify(this.state, times(1)).next();
    }

}