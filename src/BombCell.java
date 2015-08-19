/**
 * Created by vinhbachsy on 19/8/15.
 */
public class BombCell extends Cell {
    @Override
    public void dig() throws ExplodeException {
        throw new ExplodeException();
    }

    @Override
    public boolean isBomb() {
        return true;
    }
}
