import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class preorderiterativestack {
    public static class Node {
        int val;
        Lc257.Node left;
        Lc257.Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public List<Integer> preorderTraversal(Node root) {
        List<Integer> preorder=new ArrayList<>();
        Stack<Node> st= new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            root=st.pop();
            preorder.add(root.val);
            if(root.right!=null)st.add(root.right);
            if(root.left!=null)st.add(root.left);
        }
        return preorder;
    }
    public static void main(String[] args) {

    }
}
