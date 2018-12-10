package Linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val > o2.val) {
                    return 1;
                } else
                    return 0;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                heap.add(lists[i]);
        }
        ListNode head = new ListNode(0);
        ListNode result = head;
        while (!heap.isEmpty()) {
            ListNode x = heap.poll();
            head.next = x;
            if (x.next != null)
                heap.offer(x.next);
            head = head.next;
        }
        return result.next;
    }
}
