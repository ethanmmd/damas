package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ControllerTest {

    @InjectMocks
    private Controller controller;

    @Mock
    private Game game;

    @Mock
    private State state;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testControllerWhenGetDimensionIsCalledThenDimensionIsReturned() {
        when(this.game.getDimension()).thenReturn(Coordinate.getDimension());
        int dimension = this.controller.getDimension();
        assertThat(dimension, is(Coordinate.getDimension()));
        verify(this.game, times(1)).getDimension();
    }

}