import java.util.HashSet;
import java.util.Set;

public class Lc219containdupII {
    
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        // Set<Integer> hs = new HashSet<>();

        // int low = 0;
        // boolean flag = false;

        // for(int high = 0; high < n; high++){

        //     // check duplicate first
        //     if(hs.contains(nums[high])){
        //         return true;
        //     }

        //     hs.add(nums[high]);

        //     // shrink window if size > k
        //     while(high - low >= k){
        //         hs.remove(nums[low]);
        //         low++;    
        //     }
        // }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
               
                if (nums[i] == nums[j] && j - i < k)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }
}