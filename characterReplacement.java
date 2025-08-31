import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k){
        if(s.length() == 0){
            return 0;
        }

        HashMap<Character, Integer> freq = new HashMap<>();
        int l = 0, res = 0;

        for(int r = 0; r < s.length(); r++){
            char currChar = s.charAt(r);
            freq.put(currChar, freq.getOrDefault(currChar, 0) + 1);
            int maxf = Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getValue();
            while((r - l + 1) - maxf > k){
                freq.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res, (r - l + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.characterReplacement("AACACCBABB", 1);
        System.out.println(res == 4);
    }
}
