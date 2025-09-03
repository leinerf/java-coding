public class ReorderLinkedList {
    public static void reorderLinkedList(ListNode head) {
        ListNode hare = head, turtle = head;
        while(hare != null){
            hare = hare.next;
            turtle = turtle.next;
            if(hare == null){
                break;
            }
            hare = hare.next;
        }

        ListNode prev = null;
        while(turtle != null){
            ListNode temp = turtle.next;
            turtle.next = prev;
            prev = turtle;
            turtle = temp;
        }

        while(prev != null){
            ListNode t1 = head.next;
            ListNode t2 = prev.next;
            
            head.next = prev;
            prev.next = t1;

            head = t1;
            prev = t2;
        }

        head.next = null;
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
        reorderLinkedList(dummy.next);
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