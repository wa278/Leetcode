package Linked_list;

import java.util.Stack;

public class Add_Two_Numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2);
            l2 = l2.next;
        }
        ListNode head = null;
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag == 1) {
            int a = 0;
            if (!stack1.isEmpty()) {
                a = stack1.pop().val;
            }
            int b = 0;
            if (!stack2.isEmpty()) {
                b = stack2.pop().val;
            }
            ListNode temp = new ListNode((a + b + flag) % 10);
            flag = (a + b + flag) / 10;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
