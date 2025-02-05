public class Board{
    public final static int rows = 8;
    public final static int columns = 8;

    public static Piece[][] grid = new Piece[rows][columns];

    public String toString(){
        String s = "";

        for(int i = 0; i < Board.rows; i++){
            for(int j = 0; j < Board.columns; j++){
                Piece item = Board.grid[i][j];
                if(j==0) s+=String.format("|%s|", item==null ? " " : item.toString());
                else s+=String.format("%s|", item==null ? " ": item.toString());
            }
            s+="\n"+"-".repeat(columns*2+1)+"\n";
    
        }


        return s;
    }

    public static void main(String[] args){
        Board b = new Board();
        System.out.println(b);
    }

}

/*
 * ----------
 * | | | | | |
 * -----------
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */