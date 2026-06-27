import java.util.*;

public class Allviews {
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
        int hd;         //horizontal distance

        public pair(Node curr, int hd) {
            this.curr = curr;
            this.hd = hd;
        }
    }
//
    public static void printbfstopview(Node root){

        Queue<pair> q=new LinkedList<>();
        Map<Integer,Integer> hm=new TreeMap();

        if(root == null) return;

        q.add(new pair(root,0));

        while(q.size()>0){
            int currhd=q.peek().hd;
            pair curr=q.poll();

            if(!hm.containsKey(currhd)){
                hm.put(currhd,curr.curr.val);
            }

            if(curr.curr.left!=null)q.add(new pair(curr.curr.left,currhd-1));
            if(curr.curr.right!=null)q.add(new pair(curr.curr.right,currhd+1));
        }

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            System.out.print(entry.getValue()+"->");
        }
    }

    public static void printbfsbottomview(Node root){

        Queue<pair> q=new LinkedList<>();
        Map<Integer,Integer> hm=new TreeMap();

        if(root == null) return;

        q.add(new pair(root,0));

        while(q.size()>0){
            int currhd=q.peek().hd;
            pair curr=q.poll();

            hm.put(currhd,curr.curr.val);

            if(curr.curr.left!=null)q.add(new pair(curr.curr.left,currhd-1));
            if(curr.curr.right!=null)q.add(new pair(curr.curr.right,currhd+1));
        }

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            System.out.print(entry.getValue()+"->");
        }
    }

    public static void printbfsleftview(Node root){

        Queue<pair> q=new LinkedList<>();
        Map<Integer,Integer> hm=new TreeMap();

        if(root == null) return;

        q.add(new pair(root,0));

        while(q.size()>0){
            int currhd=q.peek().hd;
            pair curr=q.poll();

            if(!hm.containsKey(currhd)) {
                hm.put(currhd, curr.curr.val);
            }
            if(curr.curr.left!=null)q.add(new pair(curr.curr.left,currhd+1));
            if(curr.curr.right!=null)q.add(new pair(curr.curr.right,currhd+1));
        }

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            System.out.print(entry.getValue()+"->");
        }
    }

    public static void printbfsrightview(Node root){

        Queue<pair> q=new LinkedList<>();
        Map<Integer,Integer> hm=new TreeMap<>();


        if(root == null) return;

        q.add(new pair(root,0));

        while(q.size()>0){
            int currhd=q.peek().hd;
            pair curr=q.poll();

            hm.put(currhd,curr.curr.val);

            if(curr.curr.left!=null)q.add(new pair(curr.curr.left,currhd+1));
            if(curr.curr.right!=null)q.add(new pair(curr.curr.right,currhd+1));
        }

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            System.out.print(entry.getValue()+"->");
              }
    }

    static void main() {
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


        c.left = d;
        c.right = e;
        b.left = f;
        b.right = g;
        g.left = h;
        g.right = i;


        printbfstopview(a);
        System.out.println();
        printbfsbottomview(a);
        System.out.println();
        printbfsrightview(a);
        System.out.println();
        printbfsleftview(a);
    }
}
