import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by vinhbachsy on 19/8/15.
 */
public class BoardTest {
    private Board board;
    private BoardPresenter boardPresenter;

    @Before
    public void setup() {
        board = new Board(1,0);
        //boardPresenter = new BoardPresenter(2, cells);
    }

    @Test
    public void testInitializeWithSize() throws Exception {
        assertEquals(1, board.size());
    }

    @Test
    public void testShouldOutput() throws Exception {
        assertEquals("# \n", board.output());
    }

    @Test
    public void testShouldAcceptActionDig() throws Exception {
        board.processInput(0, 0, "D");
        assertEquals(". \n", board.output());
    }

    @Test
         public void testShouldAcceptActionFlag() throws Exception {
        board.processInput(0, 0, "F");
        assertEquals("F \n", board.output());
    }

    @Test
    public void testShouldAcceptActionToggleFlag() throws Exception {
        board.processInput(0, 0, "F");
        board.processInput(0, 0, "F");
        assertEquals("# \n", board.output());
    }
}
