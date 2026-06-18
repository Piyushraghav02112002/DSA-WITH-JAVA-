import java.util.ArrayList;
import java.util.List;

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

    public static void calpermutation2(int[] nums, List<Integer> curr, List<List<Integer>> ans, boolean[] mark) {

        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!mark[i]){
                mark[i]=true;
                curr.add(nums[i]);
                calpermutation2(nums,curr,ans,mark);
                curr.remove(curr.size()-1);
                mark[i]=false;
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();       //this is 2nd approach
        boolean[] mark = new boolean[nums.length];

        //calpermutation(nums,0,ans);       //for 1st approach
        calpermutation2(nums,curr,ans,mark);
        return ans;
    }



    public static void main(String[] args) {

        int nums[]={1,2,3};

        List<List<Integer>> l=permute(nums);
        for(var ans:l){
            System.out.println(ans);
        }


    }
}
