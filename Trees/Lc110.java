public class Lc110 {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static int findheight(Node root) {
        if (root == null || root.left == null && root.right == null)
            return 0;

        return 1 + Math.max(findheight(root.left), findheight(root.right));

    }

    public boolean isBalanced(Node root) {
        if(root==null)return true;

        int left=findheight(root.left);
        if(root.left!=null)left++;

        int right=findheight(root.right);
        if(root.right!=null)right++;

        int diff=left-right;

        if(diff<0)diff=-diff;

        if(diff>1)return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }
    public static void main(String[] args) {

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);

        a.left = b;
        a.right = c;

        Node d = new Node(3);
        Node e = new Node(3);

        b.left = d;
        b.right = e;

        Node f = new Node(4);
        Node g = new Node(4);
        d.left=f;
        d.right=g;


    }
}
