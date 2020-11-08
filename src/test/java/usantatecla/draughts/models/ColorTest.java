package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import static usantatecla.draughts.models.Color.*;
import static usantatecla.draughts.models.Color.BLACK;
import static usantatecla.draughts.models.Color.WHITE;

public class ColorTest {

    private final Coordinate coordinate = Mockito.mock(Coordinate.class);

    @Before
    public void setUp() {
        Mockito.reset(coordinate);
    }

    @Test
    public void testColorWhenCoordinateIsNotBlack() {
        when(coordinate.isBlack()).thenReturn(FALSE);
        assertNull(getInitialColor(coordinate));
    }

    @Test
    public void testColorWhenCoordinateIsBlackAndRowBelongsToWhite() {
        when(coordinate.isBlack()).thenReturn(TRUE);
        when(coordinate.getRow()).thenReturn(5);
        assertThat(getInitialColor(coordinate), is(WHITE));
    }

    @Test
    public void testColorWhenCoordinateIsBlackAndRowBelongsToBlack() {
        when(coordinate.isBlack()).thenReturn(TRUE);
        when(coordinate.getRow()).thenReturn(2);
        getInitialColor(coordinate);
        assertThat(getInitialColor(coordinate), is(BLACK));
    }

    @Test
    public void testColorWhenCoordinateIsBlackAndRowHasNoColor() {
        when(coordinate.isBlack()).thenReturn(TRUE);
        when(coordinate.getRow()).thenReturn(3);
        assertNull(getInitialColor(coordinate));
    }


}
