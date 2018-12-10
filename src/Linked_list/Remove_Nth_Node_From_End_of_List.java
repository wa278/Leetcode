package Linked_list;

public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode index = head;
        int i = 0;
        while (index.next != null && i < n) {
            index = index.next;
            i++;
        }
        if (i == n) {
            while (index.next != null) {
                index = index.next;
                pre = pre.next;
            }
            pre.next = pre.next.next;
            return head;
        } else if (i == n - 1) {
            return head.next;
        } else {
            return null;
        }
    }
}
