import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinMeetingRooms {

    public int minMeetingRooms(List<Interval> intervals){
        PriorityQueue<Interval> queue = new PriorityQueue<>(Comparator.comparing((Interval interval) -> interval.end));
        intervals.sort(Comparator.comparing((Interval interval) -> interval.end));
        queue.add(intervals.remove(0));
        intervals.sort(Comparator.comparing((Interval interval) -> interval.start));
        for(Interval interval: intervals){
            if(queue.peek().end <= interval.start){
                queue.remove();
            }
            queue.add(interval);
        }
        return queue.size();
    }
    public static void main(String[] args) {
        // [(0,40),(5,10),(15,20)]
        ArrayList<Interval> test = new ArrayList<>(
            Arrays.asList(
                new Interval(0, 40),
                new Interval(5, 10),
                new Interval(15, 20)
            )
        );
        MinMeetingRooms sol = new MinMeetingRooms();
        System.out.println(sol.minMeetingRooms(test) == 2);
    }
}
