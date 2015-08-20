import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by vinhbachsy on 20/8/15.
 */
public class CellGeneratorTest {
    @Test
    public void testGenerate() throws Exception {
        for (int i = 0; i < 10; i++) {
            CellGenerator generator = new CellGenerator(1, 0);
            Cell[][] cells = generator.generate();
            assertTrue(cells[0][0] instanceof NormalCell);
        }
    }

    @Test
    public void testGenerateBomb() throws Exception {
        for (int i = 0; i < 10; i++) {
            CellGenerator generator = new CellGenerator(1, 1);
            Cell[][] cells = generator.generate();
            assertTrue(cells[0][0] instanceof BombCell);
        }
    }
}
