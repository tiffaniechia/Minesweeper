/**
 * Created by vinhbachsy on 20/8/15.
 */
public class ClearFlagAction extends ActionInput {
    @Override
    public void execute(Cell cell) throws FlagUnmaskedCellException {
        if (!cell.isFlagged()) throw new FlagUnmaskedCellException("Can not clear unflagged cell");
        cell.unflag();
    }
}
