import java.util.ArrayList;
import java.util.List;

public class Lc51NQueen {

    public static boolean isvalid(char board[][],int row,int col){
        int n=board.length;

        for (int i = 0; i < row; i++) {
            if(board[i][col]=='Q')return false;
        }
        for (int j = 0; j < col; j++) {
            if(board[row][j]=='Q')return false;
        }

        //for the northeast
        int i=row,j=col;
        while(i>=0 && j<n){
            if(board[i][j]=='Q')return false;
            i--;
            j++;

        }

        //for the Westnorth
        i=row;
        j=col;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q')return false;
            i--;
            j--;

        }

        // //for the Westsouth
        // i=row;
        // j=col;
        // while(i<n && j>=0){
        //     if(board[i][j]=='Q')return false;
        //     i++;
        //     j--;
        // }

        // //for the Southeast
        // i=row;
        // j=col;
        // while(i<n && j<n){
        //     if(board[i][j]=='Q')return false;
        //     i++;
        //     j++;
        // }
        return true;
    }

    public static void calNQueens(char board[][],int row,  List<List<String>> ans) {
        int n=board.length;


        if(row==n){
            List<String> curr=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str="";
                for(int j = 0; j < n; j++) {
                    str+=board[i][j];
                }
                curr.add(str);
            }
            ans.add(new ArrayList<>(curr));
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//
//                    System.out.print(board[i][j]+" ");
//                }
//                System.out.println();
//            }
            return;
        }
        for(int j=0;j<n;j++){

            if(isvalid(board,row,j)) {
                board[row][j] = 'Q';
                calNQueens(board,row+1,ans);
                board[row][j]='.';
            }
        }
    }
    public static void main(String[] args) {
        int n=4;
        char[][] board=new char[n][n];
        List<List<String>> list=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        calNQueens(board,0,list);

    }
}
