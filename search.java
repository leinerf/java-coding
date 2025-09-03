import java.lang.Math;

/*
Search in Rotated Sorted Array
*/
class Solution {
    public int search(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while(l != r){
            int upper = l + Math.floorDiv(r - l + 1,2);
            int lower = upper - 1;
            int[] correct = new int[]{-1,-1}, incorrect = new int[]{-1,-1};
            
            if(nums[l] <= nums[lower]){
                correct[0] = l; 
                correct[1] = lower;
                incorrect[0] = upper;
                incorrect[1] = r;
            } else {
                correct[0] = upper;
                correct[1] = r;
                incorrect[0] = l;
                incorrect[1] = lower;
            }

            if(target >= nums[correct[0]]&& target <= nums[correct[1]]){
                l = correct[0];
                r = correct[1];
            } else {
                l = incorrect[0];
                r = incorrect[1];
            }
        }

        return (target == nums[l]) ? l : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.search(new int[]{3,4,5,6,1,2}, 1) == 4);
        System.out.println(sol.search(new int[]{3,5,6,0,1,2}, 4) == -1);

    }
}