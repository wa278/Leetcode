package Linked_list;

public class Sort_List {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode slow = getMid(head);
            ListNode mid = slow.next;
            slow.next = null;
            head = mergeSort(head);
            mid = mergeSort(mid);
            return merge(head, mid);
        }
    }

    public ListNode merge(ListNode head, ListNode mid) {
        if (head == null) {
            return mid;
        }
        if (mid == null) {
            return head;
        }
        if (head.val < mid.val) {
            head.next = merge(head.next, mid);
            return head;
        }
        if (head.val >= mid.val) {
            mid.next = merge(head, mid.next);
            return mid;
        }
        return null;
    }

    public ListNode getMid(ListNode head) {
        if (head.next.next == null) {
            return head;
        } else {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
