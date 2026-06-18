import java.util.*;

public class Lc47 {
    //First Approach
    public static void calpermuteII(int nums[],HashMap<Integer,Integer> need,List<List<Integer>> ans,List<Integer> temp){

        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(Map.Entry<Integer, Integer> entry : need.entrySet()){

            if(entry.getValue()==0){
                continue;
            }

            temp.add(entry.getKey());
            need.put(entry.getKey(), entry.getValue()-1);

            calpermuteII(nums,need,ans,temp);

            temp.removeLast();
            need.put(entry.getKey(), entry.getValue()+1);

        }
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {

        HashMap<Integer,Integer> need=new HashMap<>();      //for first Approach

        List<List<Integer>> list=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            need.put(nums[i],need.getOrDefault(nums[i],0)+1);
        }
        calpermuteII(nums,need,list,new ArrayList<>());
        return list;
     }



    public static void main(String[] args) {
        int nums[]={1,1,2};

        List<List<Integer>> l=permuteUnique(nums);
        for(var ans:l){
            System.out.println(ans);
        }

    }
}
