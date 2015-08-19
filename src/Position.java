import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vinhbachsy on 19/8/15.
 */
public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position[] neighbourPositions() {
        return new Position[]{
                new Position(x - 1, y - 1),
                new Position(x, y - 1),
                new Position(x + 1, y - 1),
                new Position(x - 1, y),
                new Position(x + 1, y),
                new Position(x - 1, y + 1),
                new Position(x, y + 1),
                new Position(x + 1, y + 1)
        };
    }

    public boolean isWithinBoard(int size) {
        return x < size && x >= 0 && y < size && y >= 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
