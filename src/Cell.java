/**
 * Created by vinhbachsy on 19/8/15.
 */
public abstract class Cell {
    protected CellState state = CellState.MASKED;

    public boolean isMasked() {
        return state == CellState.MASKED;
    }

    public boolean isFlagged() {
        return state == CellState.FLAGGED;
    }

    public abstract void dig() throws ExplodeException;

    public abstract boolean isBomb();


    public void flag() {
        state = CellState.FLAGGED;
    }

    public void unflag() {
        state = CellState.MASKED;
    }
}
