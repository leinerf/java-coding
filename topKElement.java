import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] topKFrequent(int[] nums, int k){
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(int i = 0; i < nums.length + 1; i++){
            buckets.add(new ArrayList<Integer>());
        }
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            int key = entry.getKey();
            int count = entry.getValue();
            buckets.get(count).add(key);
        }
        
        int[] res = new int[k];
        int index = 0;
        System.out.println(buckets.toString());
        for(int i = buckets.size() - 1; i > 0; i--){
            for(int j: buckets.get(i)){
                res[index++] = j;
                if(index == k){
                    return res;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
            Arrays.toString(sol.topKFrequent(new int[]{5,5,5,1,2,2,3,3,3}, 2))
        );
    }
}