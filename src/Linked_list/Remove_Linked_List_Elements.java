package Linked_list;

public class Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                pre.next = head;
            } else {
                head = head.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
