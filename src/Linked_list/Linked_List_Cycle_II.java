package Linked_list;

public class Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            i++;
            if (fast == slow) {
                ListNode second = head;
                while (slow != second) {
                    slow = slow.next;
                    second = second.next;
                }
                return slow;
            }
        }
        return null;
    }
}
