import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    MedianFinder(){}
    public void addNum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(maxHeap.size() - minHeap.size() > 2){
            minHeap.add(maxHeap.remove());
        }
        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.remove());
        }
    }
    public double findMedian(){
        if((minHeap.size() + maxHeap.size()) % 2 == 0){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        MedianFinder sol = new MedianFinder();
        sol.addNum(0);
        System.out.println(sol.findMedian() == 0);
        sol.addNum(3);
        System.out.println(sol.findMedian() == 1.5);
        sol.addNum(20);
        System.out.println(sol.findMedian() == 3);
    }
}
