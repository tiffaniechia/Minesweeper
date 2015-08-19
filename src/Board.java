/**
 * Created by vinhbachsy on 19/8/15.
 */
public class Board {
    private CellCollection cells;
    private BoardPresenter boardpresenter;


    public Board(int size, int bombCount) {
        CellGenerator generator = new CellGenerator(size, bombCount);
        this.cells = new CellCollection(generator.generate());
        boardpresenter = new BoardPresenter(size, cells);
    }

    public int size() {
        return cells.size();
    }

    public String output() {

        return boardpresenter.display();
    }

    public void processInput(int xPosition, int yPosition, String action) {
        try {
            Cell cell = cells.getAt(xPosition, yPosition);
            if(action == "D") {cell.dig();}
            else if(action == "F") {cell.toggleFlag();}
            output();
        } catch (ExplodeException exception) {
        } catch (FlagUnmaskedCellException exception) {
        }
    }

}
