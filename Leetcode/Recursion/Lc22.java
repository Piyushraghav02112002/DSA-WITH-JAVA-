import java.util.ArrayList;
import java.util.List;

public class Lc22
{
    public static void genparent(int n ,List<String> ans,StringBuilder curr,int open,int close){
        if(curr.length()==2*n){
               ans.add(new String(curr));
               return;
        }
        if(open<n) {
            curr.append("(");
            genparent(n,ans,curr,open+1,close);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open){
            curr.append(")");
            genparent(n,ans,curr,open,close+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public static List<String> generateParenthesis(int n) {

      StringBuilder curr=new StringBuilder();
      List<String> ans=new ArrayList<>();
        int open=0;
        int close=0;

      genparent(n,ans,curr,open,close);
      return ans;
    }

    public static void main(String[] args) {
        int n= 3;
        List<String> res=generateParenthesis(2);

        for(String ans : res){
            System.out.println(ans);
        }
    }
}
