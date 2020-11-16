package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.utils.Console;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class StartViewTest {

    private static final String TITLE = "Draughts";

    @Mock
    private StartController startController;

    @Mock
    private Console console;

    @InjectMocks
    private StartView startView;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test(expected = AssertionError.class)
    public void testStartViewWhenStartControllerIsNullThenThrowsAssertionError() {
        this.startView.interact(null);
    }

    @Test
    public void testStartViewWhenStartControllerIsNotNullThenTitleIsShownAndBoardIsShownAndStartIsCalled() {
        this.startView.interact(this.startController);
        verify(this.console, times(1)).writeln(TITLE);
        verify(startController, times(1)).getDimension();
        verify(startController, times(1)).start();

    }
}
