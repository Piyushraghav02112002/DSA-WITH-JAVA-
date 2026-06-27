import java.util.*;

class Maxwidth {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static class pair{
        Node curr;
        int ind;

        public pair(Node curr, int ind) {
            this.curr = curr;
            this.ind = ind;
        }
    }

    public static int Solvemaxwidth(Node root){

        Queue<pair> q=new LinkedList<>();
        int maxwidth=Integer.MIN_VALUE;

        q.add(new pair(root,0));

        while(!q.isEmpty()){
            int n=q.size();
            int l=q.peek().ind;
            int r=0;

            for (int i = 0; i < n; i++) {
                pair curr=q.poll();
                    r=curr.ind;

                    if(curr.curr.left!=null)q.add(new pair(curr.curr.left,2*curr.ind+1));
                 if(curr.curr.right!=null)q.add(new pair(curr.curr.right,2*curr.ind+2));

            }
            maxwidth=Math.max(maxwidth,r-l+1);
        }
        return maxwidth;
    }

    static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        a.left = b;
        a.right = c;

        Node d = new Node(6);
        Node e = new Node(7);
        Node f = new Node(4);
        Node g = new Node(5);
        Node h = new Node(8);
        Node i = new Node(9);


        //c.left = d;
            c.right = e;
            b.left = f;
        //b.right = g;
//        g.left = h;
//        g.right = i;
        System.out.println("Maxwidth :- "+Solvemaxwidth(a));

    }
}
