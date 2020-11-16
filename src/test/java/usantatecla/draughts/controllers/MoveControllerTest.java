package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

import static org.mockito.MockitoAnnotations.initMocks;

public class MoveControllerTest {

    @InjectMocks
    private MoveController moveController;

    @Mock
    private Game game;

    @Mock
    private State state;

    private Coordinate coordinate;

    @Before
    public void setUp() {
        initMocks(this);
        this.coordinate = new Coordinate(2, 0);
    }

    @Test(expected = AssertionError.class)
    public void testMoveControllerWhenMoveIsCalledWithCoordinatesLowerThanMinimumCoordinatesThenThrowsAssertionError() {
        this.moveController.move(coordinate);
    }

    @Test(expected = AssertionError.class)
    public void testMoveControllerWhenMoveIsCalledWithNullElementsOnListThenThrowsAssertionError() {
        this.moveController.move(coordinate, null);
    }


}