import java.util.Scanner;

/**
 * Created by vinhbachsy on 20/8/15.
 */
public class Minesweeper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board board = setupBoard(scan);

        while (!board.isComplete()) {
            System.out.println(board.output());
            System.out.println("Please select field [x, y, Action]: ");
            Scanner scanStepInput = new Scanner(scan.nextLine()).useDelimiter(" ");
            int xPosition = scanStepInput.nextInt();
            int yPosition = scanStepInput.nextInt();
            String action = scanStepInput.next();
            processStep(board, xPosition, yPosition, action);
        }

    }

    private static void processStep(Board board, int xPosition, int yPosition, String action) {
        try {
            board.processInput(xPosition, yPosition, action);
        } catch (ExplodeException exception) {
            System.out.println("Game Over!");
            System.exit(0);
        } catch (FlagUnmaskedCellException exception) {
            System.out.println(exception.getMessage());
        } catch (ActionInputNotFoundException exception) {
            System.out.println("Action is invalid!");
        }
    }

    private static Board setupBoard(Scanner scan) {
        System.out.println("Board setup [size, number of mines]: ");

        Scanner scanBoardInput = new Scanner(scan.nextLine()).useDelimiter(" ");
        int size = scanBoardInput.nextInt();
        int bombCount = scanBoardInput.nextInt();
        return new Board(size, bombCount);
    }
}
