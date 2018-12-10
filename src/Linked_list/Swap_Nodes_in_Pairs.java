package Linked_list;

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode tmp = head.next;
            head.next = swapPairs(tmp.next);
            tmp.next = head;
            return tmp;
        }
    }
}
