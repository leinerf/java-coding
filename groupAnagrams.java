import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> res = new HashMap<>();
        for(String str: strs){
            int[] seq = new int[26];
            for(Character c: str.toCharArray()){
                seq[c - 'a']++;
            }

            res.putIfAbsent(Arrays.toString(seq), new ArrayList<String>());
            res.get(Arrays.toString(seq)).add(str);
        }
       return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> lst = sol.groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"});
        System.out.println(lst.toString());
    }
}