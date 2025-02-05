public class Piece  {

    private int row;
    private int col;
    private int range = Integer.MAX_VALUE;
    private String icon;

    public Piece(String icon,int row, int col){
        this.icon = icon;
        this.row = row;
        this.col = col;
    }

    public Piece(String icon, int row, int col, int range){
        this.icon = icon;
        this.row = row;
        this.col = col;
        this.range = range;
    }

    public void move(int y, int x) throws Exception{
        int newRow = this.row+y;
        int newCol = this.col+x;
        
        if(this.distanceTo(y, x) > this.range) throw new Exception(String.format("(%d, %d) is out of the piece's range.", y,x));


        Board.grid[this.row][this.col] = null;
        Board.grid[newRow][newCol] = this;

        this.row = newRow;
        this.col = newCol;
    }

    public int distanceTo(int y, int x){
        return (int) Math.floor(Math.sqrt(Math.pow(this.row-y,2)+Math.pow(this.col-x,2)));
    }

    public String toString(){
        return this.icon;
    }
}