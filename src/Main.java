//import java.util.*;

import java.util.Arrays;

public class Main {

    public static boolean testInput(int x, int y, String[] lines, int x1, int y1){
        if( lines.length != y){
           System.out.println("Wrong number of lines: " + lines.length + ", expected " + y);
            return false;
        }
        for(int i = 0; i < y; i++){
            if( lines[i].length() != x){
                System.out.println("Wrong number of characters in line " + i);
                return false;
            }
            if( !lines[i].matches("[01]+") ){
                System.out.println("Line " + i + "contains illegal characters.");
                return false;
            }
        }
        if( x1 >= x || x1 < 0 ){
            System.out.println("Invalid initial x coordinate.");
            return false;
        }
        if( y1 < 0 || y1 >= y){
            System.out.println("Invalid initial y coordinate.");
            return false;
        }
        return true;
    }




    public static void main (String[] args) {

         int x = Integer.parseInt(args[0]);
         int y = Integer.parseInt(args[1]);
         int x1 = Integer.parseInt(args[2+y]);
         int y1 = Integer.parseInt(args[3+y]);
         int n = Integer.parseInt(args[4+y]);
         String[] lines = Arrays.copyOfRange(args, 2, y + 2);

         testInput(x, y, lines, x1, y1);

         Board board = new Board(x, y, lines);
         board.linkNeighbours();
        int result= 0;

        for(int i = 0; i <= n; i++){
            board.printBoard();
             result += board.currentConfiguration[y1][x1].colour;
             board.updateBoard();
             System.out.print("\n");
         }
         System.out.println(result);
    }
}
