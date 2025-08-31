import java.lang.Math;

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l = 0, r = 1;
        while(r < prices.length){
            if(prices[l] < prices[r]){
                res = Math.max(res, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4}) == 5);
    }
}
