package Linked_list;

public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(0);
        ListNode dummy = pre;
        pre.next = head;
        ListNode start;
        ListNode then;
        int i = 0;
        while (i < m - 1) {
            pre = pre.next;
            i++;
        }
        start = pre.next;
        then = start.next;
        for (int j = 0; j < n - m; j++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
