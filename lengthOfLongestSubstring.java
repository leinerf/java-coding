import java.util.HashSet;
import java.lang.Character;
import java.lang.Math;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        HashSet<Character> uniques = new HashSet<>();
        int l = 0, r = 0, res = 0;
        while(r < s.length()){
            if(uniques.contains(s.charAt(r))){
                uniques.remove(s.charAt(l));
                l++;
            }
            
            uniques.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
        System.out.println(res == 3);
    }
}
