import java.util.LinkedList;
import java.util.Queue;

public class childsum {

        public static class Node {
            int val;
            Node left;
            Node right;

            public Node(int val) {
                this.val = val;
            }
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

            System.out.print(temp.val + "->");
            q.remove();

        }

    }

    public static void solvechildsum(Node root){

            if(root==null)return;
            int child=0;
            if(root.left != null)  child+=root.left.val;
            if(root.right != null) child+=root.right.val;

           if(child<root.val) {
               if(root.left != null) root.left.val = root.val;
               if(root.right != null) root.right.val = root.val;
           }else
               root.val=child;

           solvechildsum(root.left);
           solvechildsum(root.right);

           int total=0;
           if(root.left!=null)total+= root.left.val;
           if(root.right!=null)total+=root.right.val;
        if(total != 0) root.val = total;

     }

    public static void main(String[] args) {
            Node a = new Node(40);
            Node b = new Node(10);
            Node c = new Node(20);

            a.left = b;
            a.right = c;

            Node d = new Node(2);
            Node e = new Node(5);
            Node f = new Node(30);
            Node g = new Node(40);
            //Node h = new Node(8);
            //Node i = new Node(9);
            b.right = e;
            b.left = d;
            c.left = f;
            c.right = g;
            BFStraversal(a);
            solvechildsum(a);
            BFStraversal(a);
        }
    }
