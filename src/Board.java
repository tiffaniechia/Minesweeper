import com.sun.javaws.exceptions.ExitException;

import java.util.Scanner;

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

    public void processInput(int xPosition, int yPosition, String action) throws ExplodeException, FlagUnmaskedCellException, ActionInputNotFoundException{
        Cell cell = cells.getAt(xPosition, yPosition);
        ActionInput actionInput = ActionFactory.build(action);
        actionInput.execute(cell);
    }

    public boolean isComplete() {
        return cells.noCellLeft();
    }
}
