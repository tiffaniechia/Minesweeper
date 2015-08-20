import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by vinhbachsy on 19/8/15.
 */
public class CellCollectionTest {
    private CellCollection cellCollection;

    @Before
    public void setup() {
        Cell[][] cells = new Cell[][]{
                {new BombCell(), new NormalCell()},
                {new NormalCell(), new NormalCell()}
        };
        cellCollection = new CellCollection(cells);
    }

    @Test
    public void testInitializeWithSize() throws Exception {
        assertEquals(4, cellCollection.size());
    }

    @Test
    public void testGenerateCells() throws Exception {
        assertTrue(cellCollection.getAt(0, 0) instanceof Cell);
        assertTrue(cellCollection.getAt(0, 1) instanceof Cell);
        assertTrue(cellCollection.getAt(1, 0) instanceof Cell);
        assertTrue(cellCollection.getAt(1, 1) instanceof Cell);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAccessCellOutBound() throws Exception {
        cellCollection.getAt(2, 1);
    }

    @Test
    public void testGenerateBomb() throws Exception {
        assertTrue(cellCollection.getAt(0, 0) instanceof BombCell);
    }

    @Test
    public void testCountBombsAround() throws Exception {
        assertEquals(0, cellCollection.countBombAround(0,0));
        assertEquals(1, cellCollection.countBombAround(0, 1));
    }

    @Test
    public void testNoCellLeft() throws Exception {
        cellCollection.getAt(0,0).flag();
        cellCollection.getAt(0,1).dig();
        cellCollection.getAt(1,1).dig();
        cellCollection.getAt(1,0).dig();
        assertTrue(cellCollection.noCellLeft());
    }

    @Test
    public void testNoCellLeftWithBombMasked() throws Exception {
        cellCollection.getAt(0,1).dig();
        cellCollection.getAt(1,1).dig();
        cellCollection.getAt(1,0).dig();
        assertFalse(cellCollection.noCellLeft());
    }

    @Test
    public void testNoCellLeftWithNormalFlagged() throws Exception {
        cellCollection.getAt(0,0).flag();
        cellCollection.getAt(0,1).flag();
        cellCollection.getAt(1,1).dig();
        cellCollection.getAt(1,0).dig();
        assertFalse(cellCollection.noCellLeft());
    }
}
