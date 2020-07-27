public class Board {
    //
   protected int x, y;
   protected Cell[][] currentConfiguration;


    public Board(int x, int y, String[] lines) {
        this.x = x;
        this.y = y;
        currentConfiguration = new Cell[y][x];
        //filling the board, starting from the first row
        for (int line = 0; line < lines.length; line++) {
            for (int i = 0; i < lines[line].length(); i++) {
                int colour = Character.getNumericValue(lines[line].charAt(i));
                this.currentConfiguration[line][i] = new Cell(colour);
            }
        }
    }

    public void linkNeighbours() {
        //give each cell the address to its neighbours
        for (int line = 0; line < y; line++) {
            for (int column = 0; column < x; column++) {
                //neighbours above
                if (line - 1 >= 0) {
                    if (column - 1 >= 0) {
                        currentConfiguration[line][column].neighbours[0] = currentConfiguration[line - 1][column - 1];
                    }
                    currentConfiguration[line][column].neighbours[1] = currentConfiguration[line - 1][column];
                    if (column + 1 < x) {
                        currentConfiguration[line][column].neighbours[2] = currentConfiguration[line - 1][column + 1];
                    }
                }
                //neighbours on the same level
                if (column - 1 >= 0) {
                    currentConfiguration[line][column].neighbours[3] = currentConfiguration[line][column - 1];
                }
                if (column + 1 < x) {
                    currentConfiguration[line][column].neighbours[4] = currentConfiguration[line][column + 1];
                }
                //neighbours below
                if (line + 1 < y) {
                    if (column - 1 >= 0) {
                        currentConfiguration[line][column].neighbours[5] = currentConfiguration[line + 1][column - 1];
                    }
                    currentConfiguration[line][column].neighbours[6] = currentConfiguration[line + 1][column];
                    if (column + 1 < x) {
                        currentConfiguration[line][column].neighbours[7] = currentConfiguration[line + 1][column + 1];
                    }
                }
            }
        }
        //
    }

    public void printBoard(){
        for(int line = 0; line < y; line++){
            System.out.print("|");
            for(int column = 0; column <x; column++){
                System.out.print(this.currentConfiguration[line][column].colour + "|");
            }
            System.out.print("\n");
        }
    }


     public void updateBoard() {
        /* The assumption here is that all the cells change colour simultaneously, based entirely on the
         current generation and not consecutively
         */
        //create new 2D array for the new state of the game
         Cell[][] newConfig = new Cell[y][x];
         //fill the new array with the new values
         for (int line = 0; line < y; line++) {
             for (int column = 0; column < x; column++) {
                 newConfig[line][column] = new Cell(this.currentConfiguration[line][column].updateColour());
             }
         }
         //exchange the current generation for the next generation
         this.currentConfiguration = newConfig;
         this.linkNeighbours();
         /*Alternatively, instead of creating a new array for each generation, one can use a 2D int
         array as a class variable in Board to store the new colour values generated from updateColour
         during the execution of updateBoard. That would mean going through all the cells once to
         generate the colour values and then again to assign the values from that int array as
         colour of the cells. We save space at the cost of time.
                  */
     }


}
