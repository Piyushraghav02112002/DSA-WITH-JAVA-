import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class Lc46 {
    public static void calpermutation(int[] nums, int ind, List<List<Integer>> ans) {
        if(ind==nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int x : nums){
                temp.add(x);
            }
            ans.add(temp);
        }

        for(int i=ind;i<nums.length;i++){
            swap(nums,ind,i);
            calpermutation(nums,ind+1,ans);
            swap(nums,ind,i);

        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();

        calpermutation(nums,0,ans);
        return ans;
    }



    public static void main(String[] args) {

    }
}
