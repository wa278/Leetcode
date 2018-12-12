package Linked_list;

import java.util.LinkedList;

public class Split_Linked_List_in_Parts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.val);
                if (cur != null) cur = cur.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        Split_Linked_List_in_Parts x = new Split_Linked_List_in_Parts();
        ListNode a = new ListNode(0);
        ListNode b = a;
        for (int i = 1; i <= 7; i++) {
            b.next = new ListNode(i);
            b = b.next;
        }
        x.splitListToParts(a.next, 3);
    }
}
