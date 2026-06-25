//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//public class Lc257 {
//    public static class Node extends preorderiterativestack.Node {
//        int val;
//        Node left;
//        Node right;
//
//        public Node(int val) {
//            super();
//            this.val = val;
//        }
//    }
//
//    public List<String> binaryTreePaths(Node root) {
//        List<String> list=new LinkedList<>();
//        helper(list,root,"");
//        return list;
//    }
//
//    private void helper(List<String> list, Node root, String s) {
//        if(root==null)return;
//
//        if(root.left==null && root.right==null){
//            s+=root.val;
//            list.add(s);
//            return;
//        }
//
//        //for the left
//        helper(list,root.left,s+root.val);
//
//        //for the right
//        helper(list,root.right,s+root.val);
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
