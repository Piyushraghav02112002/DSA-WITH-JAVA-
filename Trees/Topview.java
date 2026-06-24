import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Topview {
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

        for(Map.Entry<Integer,Integer> entryset=hm.entrySet()){
            System.out.println(entryset.getValue());
        }
    }

    static void main() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        a.left = b;
        a.right = c;

        Node d = new Node(4);
        Node e = new Node(5);

        c.left = d;
        c.right = e;

        printbfstopview(a);
    }
}
