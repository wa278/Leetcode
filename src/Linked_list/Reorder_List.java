package Linked_list;

public class Reorder_List {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode x = slow;
        slow = slow.next;
        x.next = null;
        ListNode disorder = reverse(slow);
        while (disorder != null) {
            ListNode temp = head.next;
            head.next = disorder;
            disorder = disorder.next;
            head.next.next = temp;
            head = temp;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
