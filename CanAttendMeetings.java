import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CanAttendMeetings {
    public boolean canAttendMeetings(List<Interval> intervals){
        intervals.sort(Comparator.comparing((Interval interval) -> interval.start));
        intervals.sort(Comparator.comparing((Interval interval) -> interval.end));

        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start < intervals.get(i - 1).end){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(0,30), new Interval(5, 10), new Interval(15, 20)));
        CanAttendMeetings sol = new CanAttendMeetings();
        System.out.println(sol.canAttendMeetings(intervals) == false);
    }
}
