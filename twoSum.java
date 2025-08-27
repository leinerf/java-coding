import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> prev = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            int num = nums[i];
            int diff = target - num;
            if(prev.containsKey(diff)){
                return new int[]{prev.get(diff), i};
            }
            prev.put(num, i);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.twoSum(new int[]{1,2,3,5}, 6)));
    }
}