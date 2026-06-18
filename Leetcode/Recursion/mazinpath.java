public class mazinpath {


    public static void main(String[] args) {
        int row=3,col=3;
        String str="";
       // int count=maz(1,1,row,col,str);

        maz(1,1,row,col,str);

        //System.out.println(count);

    }

    private static void maz(int srow, int scol, int endrow, int endcol,String str) {

        if(srow>endrow||scol>endcol)return;

        if(srow==endrow && scol==endcol){
            System.out.println(str);
            return;
        }
        maz(srow+1,scol,endrow,endcol,str+"D");
        maz(srow,scol+1,endrow,endcol,str+"R");
  //      int downways=maz(srow+1,scol,endrow,endcol,str+"D");
  //      int rightways=maz(srow,scol+1,endrow,endcol,str+"R");
    //    int totalways=downways+rightways;

    }
}
