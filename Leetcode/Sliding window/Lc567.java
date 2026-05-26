import java.util.HashMap;

public class Lc567{
    
    public static boolean checkInclusion(String s1, String s2) {
        int s1l = s1.length();
        int s2l = s2.length();

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> form = new HashMap<>();

        for (int i = 0; i < s1l; i++) {
            char ch = s1.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        
        int low = 0, count = 0;

        for (int high = 0; high < s2l; high++) {
            char ch = s2.charAt(high);

            form.put(ch, form.getOrDefault(ch, 0) + 1);

            if(need.containsKey(ch)&&form.get(ch).equals(need.get(ch)))
                count++;

            if (high - low + 1 > s1l) {
                char leftchar = s2.charAt(low);

                if(need.containsKey(leftchar) && need.get(leftchar).equals(form.get(leftchar)))
                    count--;
                
                form.put(leftchar, form.get(leftchar) - 1);
                
                if (form.get(leftchar) == 0) {
                    form.remove(leftchar);
                   
                 low++;
                }

                if (count == need.size()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
      
        String form = "eidbaooo", need = "ab";

        System.out.println("this is permutation :- "+checkInclusion(need, form));

    }
}