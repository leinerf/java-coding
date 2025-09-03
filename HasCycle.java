public class HasCycle {
    public static boolean hasCycle(ListNode head){
        ListNode hare = head, turtle = head;
        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
            if(turtle == hare) return true;
        }
        return false;
    } 
    public static void main(String[] args) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        ListNode repeat = null;
        for(int i = 0; i < 6; i++){
            curr.next = new ListNode(i);
            if(i == 3){
                repeat = curr.next;
            }
            curr = curr.next;
        }
        
        System.out.println(hasCycle(dummy.next));
        curr.next = repeat;
        System.out.println(hasCycle(dummy.next));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){this.val = val; this.next = next;}
}