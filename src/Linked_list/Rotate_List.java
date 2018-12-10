package Linked_list;

public class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int ct = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            ct++;
        }

        k = k % ct;
        if (k == 0) return head;

        ListNode curr = head;
        for (int i = 0; i < ct - k - 1; i++) {
            curr = curr.next;
        }
        ListNode prev = curr;
        curr = curr.next;

        tail.next = head;
        prev.next = null;

        return curr;
    }
}

