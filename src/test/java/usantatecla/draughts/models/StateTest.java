package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static java.util.stream.IntStream.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static usantatecla.draughts.models.StateValue.*;

public class StateTest {

    private State state;

    @Before
    public  void setUp() {
        state = new State();
    }

    @Test
    public void testStateWhenConstructorIsCalled() {
        assertStateValue(INITIAL);
    }

    @Test
    public void testStateWhenResetIsCalled() {
        state.reset();
        assertStateValue(INITIAL);
    }

    @Test
    public void testStateWhenStateValueIsNotExitAndNextIsCalled() {
        state.next();
        assertStateValue(IN_GAME);

        state.next();
        assertStateValue(FINAL);

        state.next();
        assertStateValue(EXIT);
    }

    @Test(expected = AssertionError.class)
    public void testStateWhenCurrentStateValueIsExitAndNextIsCalled() {
        range(0, 4).forEach(i -> state.next());
    }

    private void assertStateValue(StateValue stateValue) {
        assertThat(state.getValueState(), is(stateValue));
    }


}

