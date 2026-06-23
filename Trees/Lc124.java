public class Lc124 {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public int maxPathSum(Node root) {
        int []maxvalue=new int[1];
        maxvalue[0]=Integer.MIN_VALUE;
        maxpathdown(root,maxvalue);
        return maxvalue[0];
    }

    private int maxpathdown(Node root, int[] maxvalue) {
        if(root==null)return 0;

        int left=Math.max(0,maxpathdown(root.left,maxvalue));
        int right=Math.max(0,maxpathdown(root.right,maxvalue));

         maxvalue[0]=Math.max(maxvalue[0],left+right+root.val);
         return Math.max(left,right)+root.val;

    }


    static void main(String[] args) {

    }
}
