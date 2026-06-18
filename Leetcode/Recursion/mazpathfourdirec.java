public class mazpathfourdirec {

    public static void main(String[] args) {
        int row=3,col=3;
        boolean board[][]= new boolean[row][col];   //by default it is false

        maz(0,0,row-1,col-1,"",board);
    }

    private static void maz(int srow, int scol, int endrow, int endcol, String str, boolean[][] board) {

        if(srow<0 ||scol<0)return;

        if(srow>endrow||scol>endcol)return;
        if(board[srow][scol])return;


        if(srow==endrow && scol==endcol){
            System.out.println(str);
            return;
        }
        board[srow][scol]=true;

        maz(srow+1,scol,endrow,endcol,str+"D",board);//down

        maz(srow,scol+1,endrow,endcol,str+"R",board);//right

        maz(srow,scol-1,endrow,endcol,str+"L",board);//left

        maz(srow-1,scol,endrow,endcol,str+"U",board);//up

        board[srow][scol]=false;

    }
}
