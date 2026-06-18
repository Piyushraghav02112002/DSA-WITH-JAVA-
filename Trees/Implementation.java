

public class Implementation {
    
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    
    public static void Display(Node root) {
        
        if (root == null)
            return;

        System.out.print(root.val + "->");
       if(root.left!=null) System.out.print(root.left.val + ",");
       
       if (root.right != null)System.out.print(root.right.val);

       System.out.println();
        Display(root.left);
        Display(root.right);
        

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
        
        c.right = f;

        
        Display(a);

    }
}
