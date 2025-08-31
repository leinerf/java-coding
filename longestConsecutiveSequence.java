import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int res = 0;
        for(int num: nums){
            numSet.add(num);
        }
        for(int num: numSet){
            if(numSet.contains(num - 1)){
                continue;
            }
            int lngth = 1;
            while(numSet.contains(num + lngth)){
                lngth++;
            }
            res = Math.max(res, lngth);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int length = sol.longestConsecutive(new int[]{2,20,4,10,3,4,5});
        System.out.println(length);
    }
}