/**
 * Created by vinhbachsy on 20/8/15.
 */
public class FlagAction extends ActionInput {
    @Override
    public void execute(Cell cell) throws FlagUnmaskedCellException{
        if (!cell.isMasked()) throw new FlagUnmaskedCellException("Can not flag unmasked cell!");
        cell.flag();
    }
}
