package Linked_list;

public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            if (head.next.val == head.val) {
                ListNode index = head.next;
                while (index != null && index.val == head.val) {
                    index = index.next;
                }
                return deleteDuplicates(index);
            } else {
                head.next = deleteDuplicates(head.next);
                return head;
            }
        }
    }
}
