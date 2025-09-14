import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> st = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(st.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        WordBreak sol = new WordBreak();
        System.out.println(sol.wordBreak("neetcode", Arrays.asList("neet","code")) == true);
    }
}