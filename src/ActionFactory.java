/**
 * Created by vinhbachsy on 20/8/15.
 */
public class ActionFactory {
    public static ActionInput build(String action) throws ActionInputNotFoundException{
        switch (action) {
            case "D": return new DigAction();
            case "F": return new FlagAction();
            case "C": return new ClearFlagAction();
        }

        throw new ActionInputNotFoundException();
    }
}
