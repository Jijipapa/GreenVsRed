public class Cell {
    int colour;
    //Cell upL, upM, upR, left, right, downL, downM, downR;
    Cell[] neighbours = new Cell[8];

    public Cell(int colour) {
        this.colour = colour;
    }

    public void switchColour() {
        if (this.colour == 0) {
            this.colour = 1;
        } else if (this.colour == 1) {
            this.colour = 0;
        }
    }

    /*public void updateColour(){
        int sum = 0;
        for(int i = 0; i < 8; i++){
            if(neighbours[i] != null){
                sum += neighbours[i].colour;
            }
        }
        switch (sum){
            case 0: this.colour = 0; break;
            case 1: this.colour = 0; break;
            case 2: break;
            case 3: this.colour = 1; break;
            case 4: this.colour = 0; break;
            case 5: this.colour = 0; break;
            case 6: this.colour = 1; break;
            case 7: this.colour = 0; break;
            case 8: this.colour = 0; break;
        }
        }
}*/
    public int updateColour() {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            if (neighbours[i] != null) {
                sum += neighbours[i].colour;
            }
        }
        switch (sum) {
            case 0:
                return 0;
            case 1:
                return 0;
            case 2:
                return this.colour;
            case 3:
                return 1;
            case 4:
                return 0;
            case 5:
                return 0;
            case 6:
                return 1;
            case 7:
                return 0;
            case 8:
                return 0;
        }
        System.out.println("Failed update of cell" + this);
        return -1;
    }
}

