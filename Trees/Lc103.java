//import java.util.*;
//
//public class Lc103 {
//    public static class Node {
//        int val;
//        Node left;
//        Node right;
//
//        public Node(int val) {
//            this.val = val;
//        }
//    }
//
//    public List<List<Integer>> zigzagLevelOrder(Node root) {
//        List<List<Integer>> ans=new LinkedList<>();
//        Queue<Lc124.Node> q=new LinkedList<>();
//        Boolean flag=true;
//
//        q.add(root);
//        while (q.size()>0){
//            List<Integer> curr=new ArrayList<>();
//            int size=q.size();
//
//            for(int i=0;i<size;i++) {
//                Lc124.Node node = q.poll();
//
//                if(flag) {
//                    curr.add(node.val);           // normal: end mein add
//                } else {
//                    curr.add(0, node.val);        // zigzag: hamesha front mein add
//                }
//
//                if(node.left != null) q.add(node.left);
//                if(node.right != null) q.add(node.right);
//            }
//
//            ans.add(curr);
//        flag=!false;
//        }
//return ans;
//    }
//    public static void main() {
//
//    }
//}
