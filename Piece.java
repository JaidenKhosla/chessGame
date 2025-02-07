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
        

        if(this.distanceTo(newRow, newCol) > this.range || !this.correctDirection(y, x)) throw new Exception(String.format("(%d, %d) is out of the piece's range or direction or both.", y,x));
        else{

            Board.grid[this.row][this.col] = null;
            Board.grid[newRow][newCol] = this;

            this.row = newRow;
            this.col = newCol;
        }
    }

    public int distanceTo(int y, int x){
        return (int) Math.floor(Math.sqrt(Math.pow(this.row-y,2)+Math.pow(this.col-x,2)));
    }

    private int indexOf(int[] arr, int item, int from){
        for(int i = from; i< arr.length; i++)
            if(arr[i]==item) return i;
        return -1;
    }


    public boolean correctDirection(int y, int x){

        int[] realDirection = new int[]{y,x};
        System.out.println(realDirection[0]);
        System.out.println(realDirection[1]);
        for(int[] direction : directions){
            if(direction[0] == realDirection[0] && direction[1] == realDirection[1]) return true;
            
            if(direction[0]==0||realDirection[0]==0&&direction[0]+realDirection[0]!=0) continue;
            if(direction[1]==0||realDirection[1]==0&&direction[1]+realDirection[1]!=0) continue;

            if(realDirection[0]%direction[0]==0&&realDirection[1]%direction[1]==0) return true;
        }
        return false;
    }

    public String toString(){
        return this.icon;
    }
}