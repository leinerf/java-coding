import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            int temp = 0;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] < nums[j]){
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp + 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        LengthOfLIS sol = new LengthOfLIS();
        System.out.println(sol.lengthOfLIS(new int[]{9,1,4,2,3,3,7}) == 4);
    }
}