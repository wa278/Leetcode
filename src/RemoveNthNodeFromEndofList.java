/**
 * Created by wa941 on 2018/5/15. 两点问题，双指针间隔n,和正确答案完美契合。O(n)
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lo = head;
        ListNode hi = head;
        for(int i = 0; i < n; i++){
            hi = hi.next;
        }
        if(hi == null){
            return head.next;
        }
        while (hi.next!=null){
            hi = hi.next;
            lo = lo.next;
        }
        lo.next = lo.next.next;
        return head;
    }
}
