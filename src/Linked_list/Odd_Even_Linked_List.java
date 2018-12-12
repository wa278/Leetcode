package Linked_list;


public class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode a = odd;
        ListNode b = even;
        int k = 1;
        while (head != null){
            if((k & 1) == 1){
                odd.next = head;
                odd = odd.next;
                head = head.next;
                k++;
            }
            else {
                even.next = head;
                even = even.next;
                head = head.next;
                k++;
            }
        }
        if((k&1) == 0){
            even.next = null;
        }
        else {
            odd.next = null;
        }
        odd.next = b.next;
        return a.next;
    }
}
