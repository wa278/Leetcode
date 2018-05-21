/**
 * Created by wa941 on 2018/5/21.
 */
public class SwapNodesinPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode index = result;
        ListNode a ;
        while (head != null){
            if(head.next == null){
                break;
            }
            a = head.next.next;
            head.next.next = head;
            index.next = head.next;
            head.next = a;
            index = head;
            head = a;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        swapPairs(head);
    }
}
