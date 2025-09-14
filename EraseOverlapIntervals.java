import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    public int eraseOverLapIntervals(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[0]));
        Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[1]));
        int count = 0;
        int[] interval = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(interval[1] <= intervals[i][0]){
                interval = intervals[i];
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        EraseOverlapIntervals sol = new EraseOverlapIntervals();
        int[][] intervals = new int[][]{
            new int[]{6, 8},
            new int[]{5, 8},
            new int[]{2, 4},
            new int[]{1, 2},
            new int[]{4, 4},
            new int[]{7, 9}
        }; // [[6,8],[5,8],[2,4],[1,2],[4,4],[7,9]]
        System.out.println(sol.eraseOverLapIntervals(intervals) == 2);
    }
}
