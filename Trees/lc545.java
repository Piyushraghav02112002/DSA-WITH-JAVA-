import java.util.ArrayList;
import java.util.List;

public class lc545 {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    void addLeftBoundary(Node root, List<Integer> res){
        Node temp=root.left;

        while(temp!=null){

            if(isLeaf(temp)==false)res.add(temp.val );
            else if(temp.left!=null)temp=temp.right;
            else temp=temp.left;
        }
    }

    void addRightBoundary(Node root, List<Integer> res){

        Node temp=root.right;
        ArrayList<Integer> arr=new ArrayList<>();

        while(temp!=null){

            if(isLeaf(temp)==false)arr.add(temp.val );
            else if(temp.right!=null)temp=temp.left;
            else temp=temp.right;
        }

        for (int i = arr.size()-1; i >=0 ; i--) {
            res.add(arr.get(i));
        }
    }

    void addLeaves(Node root, List<Integer> res){
        Node temp=root;

        if(isLeaf(root)){
            res.add(temp.val);
            return;
        }
        if(temp.left!=null)addLeaves(root.left,res);
        if(temp.right!=null)addLeaves(root.right,res);

    }

   List<Integer> printBoundary(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // If the root is not a leaf,
        // add its value to the result
        if (!isLeaf(root)) {
            res.add(root.val);
        }

        // Add the left boundary, leaves,
        // and right boundary in order
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

     boolean isLeaf(Node root) {
    return (root==null || root.left==null &&root.right==null);
    }


    public static void main() {

    }
}
