/**
 * Created by vinhbachsy on 20/8/15.
 */
public abstract class ActionInput {
    public abstract void execute(Cell cell) throws FlagUnmaskedCellException, ExplodeException;
}
