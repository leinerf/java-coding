class Solution {
    public int findMin(int[] nums){
        int l = 0, r = nums.length - 1;

        while( l != r) {
            int m2 = l + Math.floorDiv(r - l + 1, 2);
            int m1 = m2 - 1;
            if(Math.min(nums[l], nums[m1]) < Math.min(nums[m2], nums[r])){
                r = m1;
            } else {
                l = m2;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMin(new int[]{3,4,5,6,1,2}));
        System.out.println(sol.findMin(new int[]{7,8,9,2,3,4,5,6}));
    }
}
