/**
 * Created by wa941 on 2018/5/16.
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode index = new ListNode(0);
        ListNode result = index;
        while (l1!=null || l2 != null){
            if(l1 == null){
                result.next = new ListNode(l2.val);
                l2 = l2.next;
                result = result.next;
            }
            else if(l2 == null){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
                result = result.next;
            }
            else if(l1.val <= l2.val){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
                result = result.next;
            }
            else {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
                result = result.next;
            }
        }
        return index.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1,l2);
    }

}
