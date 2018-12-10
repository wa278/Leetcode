package Linked_list;

public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        if (p == null) return head;
        while (p.next != null) {
            if (p.val != p.next.val) {
                p = p.next;
            } else {
                p.next = p.next.next;
            }
        }
        return head;
    }
}
