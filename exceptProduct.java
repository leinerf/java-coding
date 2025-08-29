import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length + 1];
        int[] right = new int[nums.length + 1];
        left[0] = 1; right[right.length - 1] = 1;
        
        for(int i = 0; i < nums.length; i++){
            left[i + 1] = left[i] * nums[i];
            right[right.length - 2 - i] = 
                right[right.length - 1 - i] * nums[nums.length - 1 - i];
        }
        
        for(int i = 0; i < nums.length; i++){
            res[i] = left[i] * right[i + 1];
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] res = sol.productExceptSelf(new int[]{1,2,4,6});
        System.out.println(Arrays.toString(res));
    }
}