public class Lc543 {
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

    public static int helpdiameter(Node root){
        if (root == null || root.left == null && root.right == null)
            return 0;
        int leftdiameter=helpdiameter(root.left);
        int rightdiameter=helpdiameter(root.right);
        int mid =findheight(root.left)+findheight(root.right);
        if(root.left!=null) mid++;
        if(root.right!=null) mid++;
        int max=Math.max(mid,Math.max(leftdiameter,rightdiameter));
        return max;
    }

    public static void main(String[] args) {
        preinpost.Node a = new preinpost.Node(1);
        preinpost.Node b = new preinpost.Node(2);
        preinpost.Node c = new preinpost.Node(3);

        a.left = b;
        a.right = c;

        preinpost.Node d = new preinpost.Node(4);
        preinpost.Node e = new preinpost.Node(5);

        b.left = d;
        b.right = e;

        preinpost.Node f = new preinpost.Node(7);

        c.right = f;

        preinpost.Node g = new preinpost.Node(6);
        c.left = g;

    }
}
