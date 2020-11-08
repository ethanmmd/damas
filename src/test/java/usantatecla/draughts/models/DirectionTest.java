package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static usantatecla.draughts.models.Direction.*;

public class DirectionTest {

    private final Coordinate coordinate = Mockito.mock(Coordinate.class);

    @Before
    public void setUp() {
        reset(coordinate);
    }

    @Test
    public void testDirectionWhenIsOnNEDirection() {
        when(coordinate.getRow()).thenReturn(5);
        when(coordinate.getColumn()).thenReturn(5);
        assertTrue(NE.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsNotOnNEDirection() {
        when(coordinate.getRow()).thenReturn(-5);
        when(coordinate.getColumn()).thenReturn(5);
        assertFalse(NE.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnNEDirectionAndRowIsZero() {
        when(coordinate.getRow()).thenReturn(0);
        when(coordinate.getColumn()).thenReturn(0);
        assertFalse(NE.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnNEDirectionAndIsNotDiagonal() {
        when(coordinate.getRow()).thenReturn(1);
        when(coordinate.getColumn()).thenReturn(2);
        assertFalse(NE.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnSEDirection() {
        when(coordinate.getRow()).thenReturn(-5);
        when(coordinate.getColumn()).thenReturn(5);
        assertTrue(SE.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsNotOnSEDirection() {
        when(coordinate.getRow()).thenReturn(-5);
        when(coordinate.getColumn()).thenReturn(-5);
        assertFalse(SE.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnSEDirectionAndRowIsZero() {
        when(coordinate.getRow()).thenReturn(0);
        when(coordinate.getColumn()).thenReturn(0);
        assertFalse(SE.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnSEDirectionAndIsNotDiagonal() {
        when(coordinate.getRow()).thenReturn(-2);
        when(coordinate.getColumn()).thenReturn(4);
        assertFalse(SE.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnSWDirection() {
        when(coordinate.getRow()).thenReturn(-5);
        when(coordinate.getColumn()).thenReturn(-5);
        assertTrue(SW.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsNotOnSWDirection() {
        when(coordinate.getRow()).thenReturn(5);
        when(coordinate.getColumn()).thenReturn(-5);
        assertFalse(SW.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnSWDirectionAndRowIsZero() {
        when(coordinate.getRow()).thenReturn(0);
        when(coordinate.getColumn()).thenReturn(0);
        assertFalse(SW.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnSWDirectionAndIsNotDiagonal() {
        when(coordinate.getRow()).thenReturn(-5);
        when(coordinate.getColumn()).thenReturn(-7);
        assertFalse(SW.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnNWDirection() {
        when(coordinate.getRow()).thenReturn(5);
        when(coordinate.getColumn()).thenReturn(-5);
        assertTrue(NW.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsNotOnNWDirection() {
        when(coordinate.getRow()).thenReturn(5);
        when(coordinate.getColumn()).thenReturn(5);
        assertFalse(NW.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnNWDirectionAndRowIsZero() {
        when(coordinate.getRow()).thenReturn(0);
        when(coordinate.getColumn()).thenReturn(0);
        assertFalse(NW.isOnDirection(coordinate));
    }

    @Test
    public void testDirectionWhenIsOnNWDirectionAndIsNotDiagonal() {
        when(coordinate.getRow()).thenReturn(5);
        when(coordinate.getColumn()).thenReturn(-7);
        assertFalse(NW.isOnDirection(coordinate));
    }

}
