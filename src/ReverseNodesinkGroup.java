/**
 * Created by wa941 on 2018/5/22.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode index = first;
        while (iscorrect(index,k)){
            endToFirst(index,k);
            for (int i = 0 ; i< k;i++){
                index = index.next;
            }
        }
        return first.next;


    }
    public boolean iscorrect(ListNode first, int k){
        for(int i = 0; i< k;i++){
            first = first.next;
            if(first == null){
                return false;
            }
        }
        return true;
    }
    public void endToFirst(ListNode head,int n){
        while (n != 1){
            ListNode end = head;
            for(int i = 0 ; i <n ;i ++){
                end = end.next;
            }
            ListNode p = end.next;
            end.next = head.next;
            head.next = end;
            ListNode x = head;
            for(int i = 0; i < n ;i ++){
                x = x.next;
            }
            x.next = p;
            endToFirst(head.next,--n);
            break;
        }
    }

    public static void main(String[] args) {
        ReverseNodesinkGroup a = new ReverseNodesinkGroup();
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(3);
        x.next.next.next = new ListNode(4);
        x.next.next.next.next = new ListNode(5);
        ListNode c = a.reverseKGroup(x,3);
        int m = 3;
    }
}
