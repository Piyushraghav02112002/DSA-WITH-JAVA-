import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc438findallanagram {
    
    // public static List<Integer> findAnagrams(String s, String p) {
        

    //     Map<Character, Integer> form = new HashMap<>();

    //     Map<Character, Integer> need = new HashMap<>();

    //     List<Integer> l = new ArrayList<>();

    //     for (int i = 0; i < p.length(); i++) {
    //         need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
    //     }
    //     int pn=p.length(),low=0;

    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);

    //         form.put(ch, form.getOrDefault(ch, 0) + 1);
            
    //         while (i-low+1 > pn) {
    //             form.put(s.charAt(low), form.get(s.charAt(low)) - 1);
    //             if (form.get(s.charAt(low))==0) {
    //                 form.remove(s.charAt(low));
    //             }
    //             low++;
    //         }
    //         if (form.equals(need)) {
    //             l.add(low);
    //         }
            
    //     }
    //     return l;
        
    // }
    
    public static List<Integer> findAnagrams(String s, String p) {
        

        Map<Character, Integer> form = new HashMap<>();

        Map<Character, Integer> need = new HashMap<>();

        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int pn=p.length(),low=0,count=0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            form.put(ch, form.getOrDefault(ch, 0) + 1);
          
            if (need.containsKey(ch) && form.get(ch).equals(need.get(ch)))
                count++;
            
            if (i - low + 1 > pn) {
                char leftch = s.charAt(low);
                if (need.containsKey(leftch) && form.get(leftch).equals(need.get(leftch)))
                    count--;

                form.put(leftch, form.get(leftch) - 1);

                if (form.get(leftch) == 0) {
                    form.remove(leftch);
                }
                low++;
            }
            
            if (count == need.size()) {
                l.add(low);
            }
            
            
        }
        return l;
        
    }
    public static void main(String[] args) {
        String form = "cbaebabacd", need = "abc";

        List<Integer> l = findAnagrams(form, need);

        int[] arr = l.stream().mapToInt(Integer::intValue).toArray();
        
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
