public class Piece  {

    private int row;
    private int col;
    private int range = Integer.MAX_VALUE;
    private String icon;
    private boolean canJump;
    private int[][] directions;

    public Piece(String icon,int row, int col, boolean canJump, int[][] directions){
        this.icon = icon;
        this.row = row;
        this.col = col;
        this.canJump = canJump;
        this.directions = directions;
    }

    public Piece(String icon, int row, int col, int range, boolean canJump, int[][] directions){
        this.icon = icon;
        this.row = row;
        this.col = col;
        this.range = range;
        this.canJump = canJump;
        this.directions = directions;

    }

    public void move(int y, int x) throws Exception{
        int newRow = this.row+y;
        int newCol = this.col+x;
        

        if(this.distanceTo(y, x) > this.range) throw new Exception(String.format("(%d, %d) is out of the piece's range or direction or both.", y,x));


        Board.grid[this.row][this.col] = null;
        Board.grid[newRow][newCol] = this;

        this.row = newRow;
        this.col = newCol;
    }

    public int distanceTo(int y, int x){
        return (int) Math.floor(Math.sqrt(Math.pow(this.row-y,2)+Math.pow(this.col-x,2)));
    }

    public boolean correctDirection(int y, int x){
        for(int[] direction : directions){
            int directionY = direction[0];
            int directionX = direction[1];

            int y1 = Math.abs(y-this.row)%directionY;
            int x1 = Math.abs(x-this.col)%directionX;

            if(y1==0&&x1==0) return true;
        }
        return false;
    }

    public String toString(){
        return this.icon;
    }
}