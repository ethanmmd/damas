package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.utils.Console;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static usantatecla.draughts.models.Color.BLACK;
import static usantatecla.draughts.models.Color.WHITE;

public class PlayViewTest {

    private static final String COLOR_PARAM = "#color";
    private static final String[] COLOR_VALUES = {"blancas", "negras"};
    private static final String PROMPT = "Mueven las " + PlayViewTest.COLOR_PARAM + ": ";
    private static final String CANCEL_FORMAT = "-1";
    private static final String RIGHT_FORMAT = "28.37";
    private static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";
    private static final String ERROR_MESSAGE = "Error!!! Formato incorrecto";
    private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";
    private static final Coordinate[] COORDINATES = new Coordinate[]{
            new Coordinate(1, 7), new Coordinate(2, 6)};

    @InjectMocks
    private PlayView playView;

    @Mock
    private Console console;

    @Mock
    private PlayController playController;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test(expected = AssertionError.class)
    public void testPlayViewWhenPlayControllerIsNullThenThrowsAssertionError() {
        this.playView.interact(null);
    }

    @Test
    public void testPlayViewWhenCanceledFormatIsTrueThenCancelMethodIsCalled() {
        when(playController.getColor()).thenReturn(WHITE);
        when(this.console.readString(PROMPT.replace(COLOR_PARAM, COLOR_VALUES[WHITE.ordinal()]))).thenReturn(CANCEL_FORMAT);
        this.playView.interact(this.playController);
        verify(playController, times(1)).cancel();
    }

    @Test
    public void testPlayViewWhenCanceledFormatIsFalseAndIsNotMoveFormatThenBadFormatErrorIsShown() {
        when(playController.getColor()).thenReturn(BLACK);
        when(this.console.readString(PROMPT.replace(COLOR_PARAM, COLOR_VALUES[BLACK.ordinal()]))).thenReturn("01.01", CANCEL_FORMAT);
        this.playView.interact(playController);
        verify(this.console, times(1)).writeln(ERROR_MESSAGE);

    }

    @Test
    public void testPlayViewWhenAndCoordinateIsOkThenMoveIsCalled() {
        when(playController.getColor()).thenReturn(WHITE);
        when(this.console.readString(PROMPT.replace(COLOR_PARAM, COLOR_VALUES[WHITE.ordinal()]))).thenReturn(RIGHT_FORMAT);
        this.playView.interact(this.playController);
        verify(this.playController, times(1)).move(COORDINATES);
        verify(this.playController, times(1)).isBlocked();
        verify(this.console, never()).writeln(LOST_MESSAGE);


    }


//    void interact(PlayController playController) {
//        assert playController != null;
//        Error error;
//        do {
//            error = null;
//            this.string = this.read(playController.getColor());
//            if (this.isCanceledFormat())
//                playController.cancel();
//            else if (!this.isMoveFormat()) {
//                error = Error.BAD_FORMAT;
//                this.writeError();
//            } else {
//                error = playController.move(this.getCoordinates());
//                new GameView().write(playController);
//                if (error == null && playController.isBlocked())
//                    this.writeLost();
//            }
//        } while (error != null);
//    }
//
//    private String read(Color color) {
//        final String titleColor = PlayViewTest.PROMPT.replace(PlayViewTest.COLOR_PARAM, PlayViewTest.COLOR_VALUES[color.ordinal()]);
//        return this.console.readString(titleColor);
//    }
//
//    private boolean isCanceledFormat() {
//        return string.equals(PlayViewTest.CANCEL_FORMAT);
//    }
//
//    private boolean isMoveFormat() {
//        return Pattern.compile(PlayViewTest.MOVEMENT_FORMAT).matcher(string).find();
//    }
//
//    private void writeError() {
//        this.console.writeln(PlayViewTest.ERROR_MESSAGE);
//    }
//
//    private Coordinate[] getCoordinates() {
//        assert this.isMoveFormat();
//        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
//        while (string.length() > 0) {
//            coordinateList.add(Coordinate.getInstance(string.substring(0, 2)));
//            string = string.substring(2, string.length());
//            if (string.length() > 0 && string.charAt(0) == '.')
//                string = string.substring(1, string.length());
//        }
//        Coordinate[] coordinates = new Coordinate[coordinateList.size()];
//        for (int i = 0; i < coordinates.length; i++) {
//            coordinates[i] = coordinateList.get(i);
//        }
//        return coordinates;
//    }
//
//    private void writeLost() {
//        this.console.writeln(LOST_MESSAGE);
//    }

}