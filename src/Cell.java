public class Cell {
    int colour;
    Cell[] neighbours = new Cell[8];

    public Cell(int colour) {
        this.colour = colour;
    }

    public int updateColour() {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            if (neighbours[i] != null) {
                sum += neighbours[i].colour;
            }
        }
        switch (sum) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 7:
            case 8:
                return 0;
            case 2:
                return this.colour;
            case 3:
            case 6:
                return 1;

        }
        System.out.println("Failed update of cell" + this);
        return -1;
    }
}

