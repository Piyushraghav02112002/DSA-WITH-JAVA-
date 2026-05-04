import java.util.HashMap;
import java.util.Map;

public class Lc76minwindowsubstr {
    
    
    public static String minWindow(String s, String t) {

        int n = s.length(), n2 = t.length();

        Map<Character, Integer> need = new HashMap<>();

        Map<Character, Integer> form = new HashMap<>();

        for (int i = 0; i < n2; i++) {
            char ch = t.charAt(i); //From this loop we re making a need array which is small and store req character

            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int low = 0, count = 0, minlen = Integer.MAX_VALUE;
          String str = "";        

        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);
  
            form.put(ch, form.getOrDefault(ch, 0) + 1);
  
            if (need.containsKey(ch) && form.get(ch).intValue() == need.get(ch).intValue()) {
                count++;
            }
            
            while (count == need.size() && low <= high) {
              
                if (high - low + 1 < minlen) {
                    minlen = high - low + 1;
                    str = s.substring(low, high + 1);
                }

                char left = s.charAt(low);

                form.put(left, form.get(left) - 1);

                if (need.containsKey(left) && form.get(left) < need.get(left)) {
                    count--; //agar need HM ke andar left ki value h 
                             //or form ke left character ki value agar choti h 
                }

                low++;

            }
        
        }
        return minlen == Integer.MAX_VALUE ? "" : str;

    }
    
    public static void main(String[] args) {
        
    }
}
