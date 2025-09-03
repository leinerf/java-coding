public class RemoveNthFromEnd {
    public static ListNode removeListNode(ListNode head, int n){
        ListNode hare = head, turtle = head;
        for(int i = 0; i < n; i++){
            hare = hare.next;
            if(hare == null){
                return head.next;
            }
        }
        
        while(hare.next != null){
            turtle = turtle.next;
            hare = hare.next;
        }
        
        turtle.next = turtle.next.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for(int i = 0; i < 11; i++){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        curr = dummy.next;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
        
        removeListNode(dummy.next, 4);
        curr = dummy.next;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){this.val = val; this.next = next;}
}