
public class Position {
    private int row;
    private int col;
    private boolean taken;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
        this.taken = false;
    }

    public boolean getTaken(){
        return taken;
    }

    public int getRow() {
        return row;
    }

    public int getCol(){
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setTaken(boolean taken){
        this.taken = taken;
    }
}
