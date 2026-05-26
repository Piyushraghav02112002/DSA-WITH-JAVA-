
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Lc3_longsubstringoutrepeat {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int maxlen = Integer.MIN_VALUE, low = 0;
        
        // Set<Character> set = new HashSet<Character>();

        // for (int high = 0; high < n; high++) {
        //     char ch = s.charAt(high);
                                                //this is better
        //     while (set.contains(ch)) {
        //         set.remove(s.charAt(low));
        //         low++;
        //     }
        //     set.add(ch);
        //     maxlen = Math.max(maxlen, high - low + 1);

        // }
        // return maxlen;

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int high = 0; high < n; high++) {
            char Rch = s.charAt(high);

            while (hm.containsKey(Rch)) {
                char Lch = s.charAt(low);
                hm.put(Lch, hm.get(Lch) - 1);
             
                if (hm.get(Lch) == 0)
                    hm.remove(Lch);

                low++;
            }
            hm.put(Rch, hm.getOrDefault(Rch, 0) + 1);
            maxlen = Math.max(maxlen, high-low+1);
        }

        return maxlen;
    }




    public static void main(String[] args) {
        String str = "abcabcbb";

        System.out.println("This is the longest substring :- "+lengthOfLongestSubstring(str));
    }
}
