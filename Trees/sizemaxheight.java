import java.util.LinkedList;
import java.util.Queue;

public class sizemaxheight {
    
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void Display(Node a) {
        
        if (a == null)
            return;

        System.out.print(a.val + "->");
       if(a.left!=null) System.out.print(a.left.val + ",");
       if (a.right != null)
           System.out.print(a.right.val);

       System.out.println();
        Display(a.left);
        Display(a.right);
        

    } 
  
    public static int size(Node root) {
        if (root == null)
            return 0;

        return 1 + size(root.left) + size(root.right);

    }
     
    public static int Findsum(Node root) {
        if (root == null)
            return 0;

        return root.val + Findsum(root.left) + Findsum(root.right);
    }

    public static int Findmax(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int a = root.val;
        int b = Findmax(root.left);
        int c = Findmax(root.right);

        return Math.max(a, Math.max(b, c));

    }
    
    public static int findheight(Node root) {
        if (root == null || root.left == null && root.right == null)
            return 0;

        return 1 + Math.max(findheight(root.left), findheight(root.right));

    }
    
    public static int findmin(Node root) {

        if (root == null)
            return Integer.MAX_VALUE;

        return Math.min(root.val, Math.min(findmin(root.left), findmin(root.right)));

    }

    public static int findprod(Node root) {

        if (root == null)
            return 1;

        if (root.left == null && root.right == null)
            return root.val;

        return root.val * findprod(root.left) * findprod(root.right);

    }
    
    public static void displaynthlvl(Node root, int nthlvl) {
        if (root == null)
            return;

        if (nthlvl == 1) {
            System.out.print(root.val + " ");
        }
        displaynthlvl(root.left, nthlvl - 1);
        displaynthlvl(root.right, nthlvl - 1);
    }
    
    public static void BFStraversal(Node root) {
        
        Queue<Node> q = new LinkedList<>();

        if(root!=null)
        q.add(root);

        while (q.size() > 0) {
            Node temp = q.peek();

            if (temp.left != null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
            
            System.out.print(temp.val + " ");
            q.remove();
       
        }

    }

    public static void main(String[] args) {

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        a.left = b;
        a.right = c;

        Node d = new Node(4);
        Node e = new Node(5);

        b.left = d;
        b.right = e;

        Node f = new Node(6);

        c.left = f;

        Node g = new Node(7);
        c.right = g;

        // System.out.println("Size of tree is :- " + size(a));

        // System.out.println(" Sum of tree is :- " + Findsum(a));

        // System.out.println(" Max of this tree :- " + Findmax(a));

        // System.out.println(" Height of this tree :- " + findheight(a));

        // System.out.println("Minimum value of tree :- " + findmin(a));

        // System.out.println("Product of tree :- " + findprod(a));

        // int level = findheight(a) + 1;
        // for (int i = 1; i <= level; i++) {
        //     displaynthlvl(a, i);
        //     System.out.println();
        // }

        BFStraversal(a);
    }
}
