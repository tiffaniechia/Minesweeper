/**
 * Created by vinhbachsy on 19/8/15.
 */
public class BoardPresenter {
    private int size;
    private CellCollection cellCollection;

    public BoardPresenter(int size, CellCollection cellCollection) {
        this.size = size;

        this.cellCollection = cellCollection;
    }


    public String display() {
        String output = "";
        for (int i = 0; i < size; i++) {
            output += displayCellRow(i);
        }
        return output;
    }

    private String displayCellRow(int i) {
        String output = "";
        for (int j = 0; j < size; j++) {
            output += displayCell(i, j);
        }
        output += "\n";
        return output;
    }

    public String displayCell(int xPosition, int yPosition) {
        Cell cell = cellCollection.getAt(xPosition, yPosition);
        if (cell.isFlagged()) return "F ";
        if (cell.isMasked()) return "# ";
        return displayNeighbourBombCount(xPosition, yPosition);
    }

    private String displayNeighbourBombCount(int xPosition, int yPosition) {
        long count = cellCollection.countBombAround(xPosition, yPosition);
        if(count == 0) return ". ";
        return String.format("%d ", count);
    }

}
