package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.utils.YesNoDialog;

import static java.lang.Boolean.TRUE;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ResumeViewTest {

    private static final String MESSAGE = "¿Queréis jugar otra";

    @InjectMocks
    private ResumeView resumeView;

    @Mock
    private YesNoDialog yesNoDialog;

    @Mock
    private ResumeController resumeController;


    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test(expected = AssertionError.class)
    public void testResumeViewWhenResumeControllerIsNullThenThrowsAssertionError() {
        this.resumeView.interact(null);
    }

    @Test
    public void testResumeViewWhenYesNoDialogIsYesThenResetIsCalled() {
        when(yesNoDialog.read(MESSAGE)).thenReturn(TRUE);
        this.resumeView.interact(resumeController);
        verify(this.resumeController, times(1)).reset();
    }

    @Test
    public void testResumeViewWhenYesNoDiaglogIsNoThenNextIsCalledWhichIsExit() {
        this.resumeView.interact(resumeController);
        verify(this.resumeController, times(1)).next();

    }
}
