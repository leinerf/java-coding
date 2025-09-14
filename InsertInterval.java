import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval){
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }
        List<int[]> res = new ArrayList<>();
        boolean intervalAdded = false;
        int i = 0;
        while(i < intervals.length){
            if(!intervalAdded && newInterval[0] <= intervals[i][1]){
                newInterval[0] = Math.min(newInterval[0], Math.min(intervals[i][0], intervals[i][1]));
                while(newInterval[1] >=  intervals[i][0]){
                    newInterval[1] = Math.max(newInterval[1], Math.max(intervals[i][0], intervals[i][1]));
                    i++;
                }
                res.add(newInterval);
                intervalAdded = true;
            } else {
                res.add(intervals[i]);
                i++;
            }
        }
        if(!intervalAdded){
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        InsertInterval sol = new InsertInterval();
        int[][] intervals = new int[][]{
            new int[]{1, 2},
            new int[]{3, 5},
            new int[]{9, 10}
        };
        int[] newInterval = new int[]{6, 7};
        int[][] target = new int[][]{
            new int[]{1, 2},
            new int[]{3, 5},
            new int[]{6, 7},
            new int[]{9, 10}
        };
        int[][] res = sol.insert(intervals, newInterval);
        System.out.println(Arrays.deepEquals(res, target));
    }
}
