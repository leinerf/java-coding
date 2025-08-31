import java.lang.Integer;
import java.util.HashMap;

class Solution {
    public static String minWindow(String s, String t) {
        if(t.length() == 0){
            return "";
        }

        HashMap<Character, Integer> sCount = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c: t.toCharArray()){
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        }

        int[] res = {-1,-1}; 
        int maxLength = Integer.MAX_VALUE, have = 0, need = sCount.size(), l = 0;
        
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(sCount.containsKey(c) && sCount.get(c).equals(window.get(c))){
                have++;
            }

            while(have == need){
                if((r - l + 1) < maxLength){
                    maxLength = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if(sCount.containsKey(leftChar) && window.get(leftChar) < sCount.get(leftChar)){
                    have--;
                }
                l++;
            }
        }
        return (maxLength == Integer.MAX_VALUE) ? "" : s.substring(res[0], res[1] + 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
    }
}