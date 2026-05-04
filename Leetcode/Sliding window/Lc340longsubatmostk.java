import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc340longsubatmostk {
    
    public static int Findlongsubatk(String s, int k) {
        
        int n = s.length();

        Map<Character, Integer> hm = new HashMap<>();

        int low = 0, maxlen = 0;

        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);

            
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            while (hm.size() > k) {
                hm.put(s.charAt(low), hm.get(s.charAt(low)) - 1);
                
                if (hm.get(s.charAt(low)) == 0) {
                    hm.remove(s.charAt(low));
                }
                low++;
            }
            maxlen = Math.max(maxlen, high - low + 1);
            
        }
        return maxlen;

    }
    
    public static void main(String[] args) {
    
        String s = "aaabbccd";
        System.out.print("Longest substring is :-"+Findlongsubatk(s, 2));


        

    }
}