import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> combos;
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combos = new ArrayList<>();
        this.nums = nums;
        getSumCombos(0, target, new ArrayList<>());
        return combos;

    }

    private void getSumCombos(int i, int target, List<Integer> combo){
        if(target == 0){
            combos.add(new ArrayList<>(combo));
        } else if(i >= nums.length || target < 0){
            return;
        } else {
            combo.add(nums[i]);
            getSumCombos(i, target - nums[i], combo);
            combo.remove(combo.size() - 1);
            getSumCombos(i + 1, target, combo);
        }
    }
    public static void main(String[] args) {
        CombinationSum sol = new CombinationSum();
        List<List<Integer>> res = sol.combinationSum(new int[]{2,5,6,9}, 9);
        System.out.println(res.toString());
    }
}