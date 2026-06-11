import java.util.ArrayList;
import java.util.List;

public class Lc78 {
     
//    private static void calsubsets(int[] nums, int i, List<Integer> curr, List<List<Integer>> ans) {
//        if (i == nums.length) {
//            ans.add(new ArrayList<>(curr));
//            return;
//        }
//
//        //pick
//        curr.add(nums[i]);
//        calsubsets(nums, i + 1, curr, ans);
//
//        //not pick
//        curr.remove(curr.size() - 1);
//        calsubsets(nums, i+1, curr, ans);
//    }
//
//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> curr = new ArrayList<>();
//
//        calsubsets(nums, 0, curr, ans);
//        return ans;
//    }
//

    private static void calsubsets(int[] nums, List<Integer> curr, List<List<Integer>> ans,int i) {

        if(i>=nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        calsubsets(nums,curr,ans,i+1);
        curr.removeLast();
        calsubsets(nums, curr, ans, i+1);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();

        calsubsets(nums,new ArrayList<>(),ans,0);
        return ans;

    }

    public static void main(String[] args) {
        int sums[] = { 1, 2, 3 };
        List<List<Integer>> ans = subsets(sums);
        
        for (List<Integer> list : ans) {
            System.out.print(list);
        }
    }
}
