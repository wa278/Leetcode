package Linked_list;

public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode a = less;
        ListNode more = new ListNode(0);
        ListNode b = more;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }

        ListNode result = new ListNode(0);
        ListNode index = result;
        if (a.next != null) {
            index.next = a.next;
            index = less;
            less.next = null;
        }
        if (b.next != null) {
            index.next = b.next;
            more.next = null;
        }
        return result.next;
    }
}
