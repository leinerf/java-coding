public class MergeTwoList {
    public ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 != null){
            curr.next = list1;
        } else if(list2 != null){
            curr.next = list2;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        MergeTwoList sol = new MergeTwoList();
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();

        ListNode curr = list1;
        for(int i: new int[]{1,5,9}){
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        curr = list2;
        for(int i: new int[]{2,8,9}){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        ListNode head = sol.mergeTwoList(list1.next, list2.next);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
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