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

        fillBombCellsIntoCells(cells);
        return cells;
    }

    private Cell[] fillCellRow() {
        Cell[] cellRow = new Cell[size];
        for (int column = 0; column < size; column++) {
            cellRow[column] =  new NormalCell();
        }
        return cellRow;
    }

    private void fillBombCellsIntoCells(Cell[][] cells) {
        while (requiredBomb > 0) {
            Random rand = new Random();
            int xPosition = rand.nextInt(size);
            int yPosition = rand.nextInt(size);
            Cell cell = cells[xPosition][yPosition];

            if (cell.isBomb()) continue;
            cells[xPosition][yPosition] = new BombCell();
            requiredBomb--;
        }
    }
}
