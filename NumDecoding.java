import java.util.HashSet;

public class NumDecoding {
    public int numDecoding(String s){
        if(s.length() == 0){
            return 0;
        }else if(s.substring(0, 1).equals("0")){
            return 0;
        } else if(s.length() == 1){
            return 1;
        }

        HashSet<String> valid = new HashSet<>();
        for(int i = 1; i < 27; i++){
            valid.add(Integer.toString(i));
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        if(valid.contains(s.substring(1,2))){
            dp[1]++;
        }
        if(valid.contains(s.substring(0, 2))){
            dp[1]++;
        }

        for(int i = 2; i < s.length(); i++){
            if(!(valid.contains(s.substring(i, i + 1)) || valid.contains(s.substring(i - 1, i +1)))){
                return 0;
            }
            if(valid.contains(s.substring(i, i + 1))){
                dp[i] += dp[i - 1];
            }
            if(valid.contains(s.substring(i - 1, i + 1))){
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length() - 1];
    }   
    public static void main(String[] args) {
        NumDecoding sol = new NumDecoding();
        System.out.println(sol.numDecoding("226") == 3);
    }
}
