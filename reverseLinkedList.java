class Solution {
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for(int i = 0; i < 5; i++){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        curr = dummy.next;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
        
        curr = sol.reverseList(dummy.next);
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