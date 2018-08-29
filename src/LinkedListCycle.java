import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
//        我的做法 空间复杂度O(n),时间复杂度O(n)
//        HashSet<ListNode> myHashSet = new HashSet<>();
//        while (head != null){
//            if(myHashSet.contains(head)){
//                return true;
//            }
//            else {
//                myHashSet.add(head);
//            }
//            head = head.next;
//        }
//        return false;
        /*空间复杂度为0，时间复杂度O(n),快节点比慢节点每次多走一步，所有至多需要O(n）次追上，如果不是成为圆环，那么可以少于O(n)*/
        if(head == null || head.next ==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null){
            if(fast == slow){
                return true;
            }
            fast= fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}



