public class Rob2 {
    public int rob(int[] nums){
        if(nums.length == 0){
            return 0;
        } else if(nums.length == 1){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];
        
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);

        for(int i = 2; i < nums.length - 1; i++){
            dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
            dp2[i] = Math.max(dp2[i - 1], nums[i + 1] + dp2[i - 2]);
        }
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);
    }
    public static void main(String[] args) {
        Rob2 sol = new Rob2();
        System.out.println(sol.rob(new int[]{2,9,8,3,6}) == 15);
    }
}
