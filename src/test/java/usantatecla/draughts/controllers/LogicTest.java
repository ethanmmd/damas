package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LogicTest {

    @InjectMocks
    private Logic logic;

    @Before
    public void setUp() {
        this.logic = new Logic();
    }

    @Test
    public void testLogicWhenGetControllerIsCalledFirstThenReturnStartController() {
        assertTrue(this.logic.getController() instanceof StartController);
    }

    @Test
    public void testLogicWhenGetControllerIsFinallyCallTheShouldReturnNull() {
        ((StartController) this.logic.getController()).start();
        ((PlayController) this.logic.getController()).cancel();
        ((ResumeController) this.logic.getController()).next();
        assertNull(this.logic.getController());
    }
}
