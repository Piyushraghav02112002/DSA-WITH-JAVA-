import java.util.HashMap;

public class Lc2461 {
    
    
    public static long maximumSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        HashMap<Integer, Integer> frq = new HashMap<>();

        int currsum = 0, low = 0;
        Long ans = (long) Integer.MIN_VALUE;
        for (int high = 0; high < n; high++) {
            int right=nums[high];

            frq.put(right, frq.getOrDefault(right, 0) + 1);
            currsum += right;

            if (high >= k) {
                currsum -= nums[high - k];
                frq.put(nums[high - k], frq.get(nums[high - k]) - 1);
                if (frq.get(nums[nums[high - k]]) == 0) {
                    frq.remove(nums[high - k]);
                }
            }
            
            if (frq.size() == k) {
                ans = Math.max(ans, currsum);
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,5,4,2,9,9,9};
        System.out.println(maximumSubarraySum(nums, 3));
    }
}