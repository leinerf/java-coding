public class MaxSubArray {
    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        MaxSubArray sol = new MaxSubArray();
        System.out.println(sol.maxSubArray(new int[]{2,-3,4,-2,2,1,-1,4}) == 8);
    }
}
