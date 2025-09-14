import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
public class IntervalMerge {
    public int[][] merge(int[][] intervals){
        if(intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int i = 1;
        while(i < intervals.length){
            int[] interval = res.get(res.size() - 1);
            if(intervals[i][0] > interval[1]){
                res.add(intervals[i]);
                i++;
            } else {
                while(interval[1] >= intervals[i][0]){
                    interval[1] = Math.max(interval[1], intervals[i][1]);
                    i++;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        IntervalMerge sol = new IntervalMerge();
        int[][] intervals = new int[][]{
            new int[]{1,3},
            new int[]{1, 5},
            new int[]{6, 7}
        }; //[[1,3],[1,5],[6,7]]
        
        int[][] target = new int[][]{
            new int[]{1,5},
            new int[]{6, 7}
        };

        System.out.println(Arrays.deepEquals(sol.merge(intervals), target));
    }
}
