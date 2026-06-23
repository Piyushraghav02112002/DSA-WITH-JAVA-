import java.util.*;

public class Lc987 {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    class pair{
        int hd;
        Node node;

        public pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        Queue<pair> q=new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> hm=new TreeMap<>();

        q.add(new pair(0,root));

        while(!q.isEmpty()){
            pair curr=q.poll();

            if(hm.containsKey(curr.hd)){
                hm.get(curr.hd).add(curr.node.val);
            }
            else{
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(curr.node.val);
                hm.put(curr.hd,arr);
            }
            if(curr.node.left!=null)q.add(new pair(curr.hd-1,curr.node.left));
            if(curr.node.right!=null)q.add(new pair(curr.hd+1,curr.node.right));

        }
            ArrayList<Integer> ans=new ArrayList<>();
            for(Map.Entry<Integer, ArrayList<Integer>> entryset: hm.entrySet()){
                ans.addAll(entryset.getValue());
            return ans;

    }
}
