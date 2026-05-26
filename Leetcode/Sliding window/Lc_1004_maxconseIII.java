

public class Lc_1004_maxconseIII {
    
    public static int longestOnes(int[] nums, int k) {
        
        int n = nums.length;

        // int maxlen = 0;

        // for (int i = 0; i < n; i++) {
        //     int zero = 0;
        //     for (int j = i; j < n; j++) {
                                                    //Brute force
        //         if (nums[j] == 0)
        //             zero++;

        //         if (zero <= k) {
        //             int currlen = j - i + 1;
        //             maxlen = Math.max(currlen, maxlen);
        //         }
        //     }
        // }
        // return maxlen;

        //   int maxlen = 0;

        // int low = 0, zeros = 0;
        
        
        // for (int high = low; high < n; high++) {

        //         if(nums[high]==0)
        //             zeros++;

        //         // if (zeros <= k) {
        //         //     int curren = high - low + 1;
        //         //     maxlen = Math.max(curren, maxlen);
        //         // }

        //         while (zeros > k) {
        //             if (nums[low] == 0)
        //                 zeros--;
        //             low++;
        //         }
        //         maxlen = Math.max(maxlen, high - low + 1);
        //     }
        // return maxlen;

        int zeros = 0, low = 0, maxlen = Integer.MIN_VALUE;
        
        for (int high = 0; high < nums.length; high++) {
            if (nums[high] == 0)
                zeros++;

            while (zeros > k) {
                if (nums[low] == 0) {
                    zeros--;
                }
                low++;
            }
            maxlen = Math.max(maxlen, high - low + 1);
        }
        return maxlen;
    }
    
    
    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };

        System.out.println(longestOnes(nums, 2));

    }
}
