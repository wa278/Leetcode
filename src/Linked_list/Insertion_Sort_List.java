package Linked_list;

public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pretemp = head;
        ListNode temp = head.next;
        while (temp != null){
            ListNode ptr = result.next;
            ListNode pre = result;
            while (ptr != temp){
                if(temp.val < ptr.val){
                    pre.next = temp;
                    pretemp.next = temp.next;
                    temp.next = ptr;
                    temp = pretemp.next;
                    break;
                }
                else {
                    ptr = ptr.next;
                    pre = pre.next;
                }
            }
            if(ptr == temp){
                temp= temp.next;
                pretemp = pretemp.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(4);
        x.next = new ListNode(1);
        x.next.next = new ListNode(2);
        x.next.next.next =  new ListNode(3);
        Insertion_Sort_List a = new Insertion_Sort_List();
        a.insertionSortList(x);
    }
}
