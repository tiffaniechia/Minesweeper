/**
 * Created by vinhbachsy on 19/8/15.
 */
public abstract class Cell {
    protected CellState state = CellState.MASKED;

    public boolean isMasked() {
        return state == CellState.MASKED;
    }

    public void toggleFlag() throws FlagUnmaskedCellException{
        if (state == CellState.UNMASKED) throw new FlagUnmaskedCellException();
        if (isFlagged()) {
            state = CellState.MASKED;
            return;
        }

        state = CellState.FLAGGED;
    }

    public boolean isFlagged() {
        return state == CellState.FLAGGED;
    }

    public abstract void dig() throws ExplodeException;

    public abstract boolean isBomb();
}
