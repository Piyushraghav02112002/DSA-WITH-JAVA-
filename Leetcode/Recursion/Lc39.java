import java.util.ArrayList;
import java.util.List;

public class Lc39 {
    
  

//    public static void calcombinationsum(int arr[],int i,List<Integer> l,List<List<Integer>> ans,int tar){
//
//        if (tar == 0) {
//            ans.add(new ArrayList<>(l));
//            return;
//        }
//        if (i == arr.length || tar < 0)
//            return;
//
//        //pick
//        l.add(arr[i]);
//        calcombinationsum(arr, i, l, ans, tar - arr[i]);
//
//        //not pick
//        l.remove(l.size() - 1);
//        calcombinationsum(arr, i+1, l, ans, tar);
//
//
//       }
//
//       public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        List<List<Integer>> ans = new ArrayList<>();
//
//        calcombinationsum(candidates, 0, new ArrayList<>(), ans, target);
//        return ans;
//
//       }
//
//

    public static void calcombinationsum(int[] arr, int i, List<Integer> l, List<List<Integer>> ans, int tar) {


        if(tar == 0){
            ans.add(new ArrayList<>(l));
            return;
        }

        if(i == arr.length || tar < 0)
            return;

        //for include
        l.add(arr[i]);
        calcombinationsum(arr,i,l,ans,tar-arr[i]);

        l.remove(l.size()-1);

        //for exclude
        calcombinationsum(arr,i+1,l,ans,tar);

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans=new ArrayList<>();

        calcombinationsum(candidates,0,new ArrayList<>(),ans,target);
        return ans;
    }
        public static void main(String[] args) {
        int nums[] = { 2, 3, 5 };

        List<List<Integer>> ans= combinationSum(nums, 8);
        System.out.println(ans);

    }
}