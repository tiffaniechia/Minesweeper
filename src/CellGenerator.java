import java.util.Random;

/**
 * Created by vinhbachsy on 19/8/15.
 */
public class CellGenerator {
    private final int size;
    private int requiredBomb;

    public CellGenerator(int size, int bombCount) {
        this.size = size;
        this.requiredBomb = bombCount;
    }

    public Cell[][] generate() {
        Cell[][] cells = new Cell[size][];
        for (int row = 0; row < size; row++) {
            cells[row] = fillCellRow();
        }
        return cells;
    }

    private Cell[] fillCellRow() {
        Cell[] cellRow = new Cell[size];
        for (int column = 0; column < size; column++) {
            cellRow[column] = makeCell();
        }
        return cellRow;
    }

    private Cell makeCell() {
        if (requiredBomb > 0) return makeBombCell();
        return new NormalCell();
    }

    private Cell makeBombCell() {
        Random rand = new Random();
        Cell cell = rand.nextBoolean() ? new NormalCell() : new BombCell() ;
        if (cell.isBomb()) requiredBomb--;
        return cell;
    }
}
