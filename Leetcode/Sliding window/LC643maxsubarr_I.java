import java.util.HashMap;

public class LC643maxsubarr_I {
    
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        double maxavg = Integer.MIN_VALUE;
        
        for (int i = 0; i < n-k; i++) {
            int sum = 0;
            for (int j = i; (j - i + 1) <= k; j++) {     //Brute force

                sum += nums[j];
            }
            double avg = (double) sum / k;
            maxavg = Math.max(maxavg, avg);
        }
        return maxavg;

        // int n = nums.length;
        // int sum = 0, maxsum = 0;

        // for (int i = 0; i < k; i++) {
        //     sum += nums[i];
        // }
        // maxsum = sum;

        // for (int i = k; i < n; i++) {
        //     sum += nums[i] - nums[i - k];
        //     maxsum = Math.max(sum, maxsum);
        // }
        // return (double) maxsum / k;

    }
    
    public static void main(String[] args) {
        int nums[] = { 1, 12, -5, -6, 50, 3 };
        
        System.out.println("This is the evrage :-"+findMaxAverage(nums, 4));
    }
}