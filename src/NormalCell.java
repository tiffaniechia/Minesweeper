/**
 * Created by vinhbachsy on 19/8/15.
 */
public class NormalCell extends Cell {
    @Override
    public void dig() throws ExplodeException {
        this.state = CellState.UNMASKED;
    }

    @Override
    public boolean isBomb() {
        return false;
    }
}
