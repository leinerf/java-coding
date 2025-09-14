public class MaxProduct {
    public int maxProduct(int[] nums){
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int res = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            max[i] = Math.max(nums[i], Math.max(nums[i] * max[i  - 1], nums[i] * min[i - 1]));
            min[i] = Math.min(nums[i], Math.min(nums[i] * max[i  - 1], nums[i] * min[i - 1]));
            res = Math.max(res, Math.max(max[i], min[i]));
        }

        return res;
    }

    public static void main(String[] args) {
        MaxProduct sol = new MaxProduct();
        System.out.println(sol.maxProduct(new int[]{1,2,-3,4}) == 4);
    }
}
