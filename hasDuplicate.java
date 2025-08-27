import java.util.HashSet;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> distinct = new HashSet<Integer>();
        for(int num : nums){
            if (distinct.contains(num)){
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    public static void main(String[] string){
        Solution sol = new Solution();
        System.out.println(sol.hasDuplicate(new int[]{1,2,3,3}));
        return;
    }
}