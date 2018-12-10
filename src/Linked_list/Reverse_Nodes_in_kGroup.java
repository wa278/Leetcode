package Linked_list;

public class Reverse_Nodes_in_kGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode current = head;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        if (count < k) {
            return head;
        } else {
            current = reverseKGroup(current, k);
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head.next = current;
            return head;
        }
    }
}
