import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for(int i = 0; i< sorted.length; i++){
            if(i != 0 && sorted[i] == sorted[i - 1]){
                continue;
            }
            int left = i + 1; int right = sorted.length - 1; int target = 0 - sorted[i];
            while(left < right){
                int guess = sorted[left] + sorted[right];
                if(guess == target){
                    res.add(Arrays.asList(sorted[i], sorted[left], sorted[right]));
                    left++;
                    while(left < right && sorted[left] == sorted[left - 1]){left++;}
                } else if(guess < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> res = sol.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(res.toString());
    }
}