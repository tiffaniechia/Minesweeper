import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vinhbachsy on 19/8/15.
 */
public class BoardPresenterTest {
    BoardPresenter boardPresenter;
    CellCollection cellCollection;
    @Before
    public void setUp() {
        Cell[][] cells = new Cell[][]{
                {new BombCell(), new NormalCell(), new NormalCell()},
                {new NormalCell(), new NormalCell(), new NormalCell()},
                {new NormalCell(), new NormalCell(), new NormalCell()}
        };
        cellCollection= new CellCollection(cells);
        boardPresenter = new BoardPresenter(3, cellCollection);
    }

    @Test
    public void testShouldDisplayMaskSymbols() throws Exception {
        assertEquals("# # # \n# # # \n# # # \n", boardPresenter.display());
    }

    @Test
    public void testShouldDisplayFlagSymbol() throws Exception {
        cellCollection.getAt(0,0).toggleFlag();
        assertEquals("F # # \n# # # \n# # # \n", boardPresenter.display());
    }

    @Test
    public void testShouldDisplayNotBombSymbol() throws Exception {
        cellCollection.getAt(2,2).dig();
        assertEquals("# # # \n# # # \n# # . \n", boardPresenter.display());
    }

    @Test
    public void testShouldDisplayNeighbouringBombCount() throws Exception {
        cellCollection.getAt(0,1).dig();
        assertEquals("# 1 # \n# # # \n# # # \n", boardPresenter.display());
    }
}
