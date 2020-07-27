//import java.util.*;

import java.util.Arrays;

public class Main {

    public static boolean testInput(int x, int y, String[] lines, int coordinateXofTargetCell, int coordinateYofTargetCell) {
        /*Test whether the input conforms to the assumptions of the program
         1.Check if the content corresponds to the dimensions of the board*/

        if (lines.length != y) {
            System.out.println("Wrong number of lines: " + lines.length + ", expected " + y);
            return false;
        }
        for (int i = 0; i < y; i++) {
            if (lines[i].length() != x) {
                System.out.println("Wrong number of characters in line " + i);
                return false;
            }
            // 2. Check if the contents of the board (the colours) are give as sequence of 0s and 1s

            if (!lines[i].matches("[01]+")) {
                System.out.println("Line " + i + "contains illegal characters.");
                return false;
            }
        }
        // 3. Check if the coordinates of the cell of interest are within the board
        if (coordinateXofTargetCell >= x || coordinateXofTargetCell < 0) {
            System.out.println("Invalid initial x coordinate.");
            return false;
        }
        if (coordinateYofTargetCell < 0 || coordinateYofTargetCell >= y) {
            System.out.println("Invalid initial y coordinate.");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        /* Expected format of the input: # of columns, # of lines, content of the lines, coordinates
        of the cell of interest, # of generations. The coordinates are flipped compared to the
        conventional (x, y), meaning the first coordinate is the y (# of lines). I find it easier
        to go through the 2D array like that.
        */
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int coordinateXofTargetCell = Integer.parseInt(args[2 + y]);
        int coordinateYofTargetCell = Integer.parseInt(args[3 + y]);
        int numberOfGenerations = Integer.parseInt(args[4 + y]);
        String[] lines = Arrays.copyOfRange(args, 2, y + 2);

        testInput(x, y, lines, coordinateXofTargetCell, coordinateYofTargetCell);

        //start the game
        Board board = new Board(x, y, lines);
        board.linkNeighbours();
        int result = 0;

        //run the given number of iterations
        for (int i = 0; i <= numberOfGenerations; i++) {
            board.printBoard();
            result += board.currentConfiguration[coordinateYofTargetCell][coordinateXofTargetCell].colour;
            board.updateBoard();
            System.out.print("\n");
        }
        //print the result
        System.out.println(result);
    }
}
