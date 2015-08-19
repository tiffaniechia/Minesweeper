import java.util.ArrayList;

/**
 * Created by vinhbachsy on 19/8/15.
 */
public class CellCollection {
    private Cell[][] cells;

    public CellCollection(Cell[][] cells) {
        this.cells = cells;
    }

    public int size() {
        return cells.length * cells.length;
    }

    public Cell getAt(int xPosition, int yPosition) {
        return cells[xPosition][yPosition];
    }

    public long countBombAround(int xPosition, int yPosition) {
        ArrayList<Cell> neighbours = getNeighbours(xPosition, yPosition);
        return neighbours.stream().filter(p -> p.isBomb()).count();
    }

    private ArrayList<Cell> getNeighbours(int xPosition, int yPosition) {
        Position currentPosition = new Position(xPosition, yPosition);
        ArrayList<Cell> neighbours = new ArrayList<Cell>();
        Position[] neighbourPositions = currentPosition.neighbourPositions();

        for (Position position:neighbourPositions) {
            if (position.isWithinBoard(cells.length)) neighbours.add(cells[position.getX()][position.getY()]);
        }
        return neighbours;
    }
}
