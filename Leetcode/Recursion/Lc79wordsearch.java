public class Lc79wordsearch {

    public static boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {

                if(board[i][j]==word.charAt(0) && find(board,i,j,word,0,n,m) )
                    return true;
            }
        }
        return false;
    }

    private static boolean find(char[][] board,int i, int j, String word, int idx,int n,int m) {
        if(idx==word.length())return true;

        if(i<0||j<0||i>=n||j>=m) return false;  // boundary
        if(board[i][j]=='$') return false;       // visited

        if(board[i][j]!=word.charAt(idx))return false;

        int temp=board[i][j];
        board[i][j]='$';

        boolean found = find(board, i+1, j, word, idx+1, n, m)  // down
                || find(board, i-1, j, word, idx+1, n, m)  // up
                || find(board, i, j+1, word, idx+1, n, m)  // right
                || find(board, i, j-1, word, idx+1, n, m); // left

        board[i][j]= (char) temp;

        return found;
    }

    public static void main(String[] args) {
       char[][] board = {{'A','B','C','E'}
               ,{'S','F','C','S'}
               ,{'A','D','E','E'}};

            String word="ABCCE";

        System.out.println(exist(board,word));


    }
}
