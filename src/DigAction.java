/**
 * Created by vinhbachsy on 20/8/15.
 */
public class DigAction extends ActionInput {
    @Override
    public void execute(Cell cell) throws ExplodeException {
        cell.dig();
    }
}
