package Linked_list;

public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int a = 0;
        ListNode copyA = headA;
        ListNode copyB = headB;
        while (copyA != null) {
            a++;
            copyA = copyA.next;
        }
        int b = 0;
        while (copyB != null) {
            b++;
            copyB = copyB.next;
        }
        if (a > b) {
            int c = a - b;
            while (c > 0) {
                headA = headA.next;
                c--;
            }
            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        } else {
            int c = b - a;
            while (c > 0) {
                headB = headB.next;
                c--;
            }
            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
