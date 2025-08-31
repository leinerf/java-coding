import java.lang.Math;

class Solution {
    public int maxArea(int[] heights){
        int res = 0;
        int left = 0;
        int right = heights.length - 1;
        while(left < right){
            int area = (right - left) * Math.min(heights[left], heights[right]);
            res = Math.max(area, res);
            if(heights[left] < heights[right]){
                left++;
            } {
                right--;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int res = sol.maxArea(new int[]{1,7,4,7,3});
        System.out.println(res);
        System.out.println(res == 14);
    }
}
