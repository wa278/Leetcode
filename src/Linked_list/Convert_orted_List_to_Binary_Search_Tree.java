package Linked_list;

public class Convert_orted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode preMid = findMid(head);
        ListNode mid = preMid.next;
        ListNode last = mid.next;
        preMid.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(last);
        return root;
    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head.next.next;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            fast = fast.next.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(-10);
        x.next = new ListNode(-3);
        x.next.next = new ListNode(0);
        x.next.next.next = new ListNode(5);
        x.next.next.next.next = new ListNode(9);
        Convert_orted_List_to_Binary_Search_Tree a = new Convert_orted_List_to_Binary_Search_Tree();
        TreeNode k = a.sortedListToBST(x);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}