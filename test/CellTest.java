import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by vinhbachsy on 19/8/15.
 */
public class CellTest {
    private Cell cell;
    @Before
    public void setup() { cell = new NormalCell(); }
    @Test
    public void testCellHaveMask() throws Exception {
        assertTrue(cell.isMasked());
    }

    @Test
    public void testFlag() throws Exception {
        cell.flag();
        assertTrue(cell.isFlagged());
    }

    @Test
    public void testFlagAgain() throws Exception {
        cell.flag();
        cell.unflag();
        assertFalse(cell.isFlagged());
    }

    @Test
    public void testDig() throws Exception {
        cell.dig();
        assertFalse(cell.isMasked());
    }

    @Test
    public void testHaveBombState() throws Exception {
        assertFalse(cell.isBomb());
        cell = new BombCell();
        assertTrue(cell.isBomb());
    }

    @Test(expected = ExplodeException.class)
    public void testExplodeIfDigBombCell() throws Exception {
        cell = new BombCell();
        cell.dig();
    }
}
