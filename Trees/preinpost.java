import org.w3c.dom.Node;

public class preinpost {
    
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void Inorder(Node root) {
        if (root == null)
            return;

        Inorder(root.left);
        System.out.print(root.val + " ");
        Inorder(root.right);
    }
    
    public static void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void Nthlevel(Node root,int n){
    if(root==null)return ;

    if(n==1) System.out.print(root.val+" ");

    Nthlevel(root.left,n-1);
    Nthlevel(root.right,n-1);

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

        Node f = new Node(7);

        c.right = f;

        Node g = new Node(6);
        c.left = g;

//        System.out.println();
//        preorder(a);
//
//        System.out.println();
//        Inorder(a);
//
//        System.out.println();
//        postorder(a);
       Nthlevel(a,3);


    }
}
