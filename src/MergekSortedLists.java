/**
 * Created by wa941 on 2018/5/17.
 */
/*
合并n 个有序数据流 用heap.时间复杂度O（mlog(n)) m是总数据。好处是时间复杂度比正常排序O(mlogm)低，并且不需要一次读入全部数据。
 */
public class MergekSortedLists {
    /*public ListNode mergeKLists(ListNode[] lists) {
        int N = lists.length;
        IndexMinPQ myPQ = new IndexMinPQ(N);
        ListNode index = new ListNode(0);
        ListNode result = index;
        for(int i = 0; i< N;i++){
            if(lists[i] != null){
                myPQ.add(i,new ListNode(lists[i].val));
                lists[i] = lists[i].next;
            }
        }
        while (!myPQ.isEmpty()){
            int s = myPQ.minIndex();
            index.next = myPQ.delMin();
            index = index.next;
            if(lists[s] != null){
                myPQ.add(s,new ListNode(lists[s].val));
                lists[s] = lists[s].next;
            }
        }
        return result.next;
    }
    private class IndexMinPQ{
        private int N = 0;
        private int n = 0;
        private int[] pq ;
        private ListNode[] key;
        public IndexMinPQ(int max){
            N = max + 1;
            pq = new int[N];
            key = new ListNode[N];
        }
        public boolean isEmpty(){
            return n == 0;
        }
        public void add(int i , ListNode x){
            n++;
            pq[n] = i;
            key[i] = x;
            swim(n);
        }
        public void swim(int n){
            while (n > 1 && less(n, n /2)){
                exch ( n , n/ 2);
                n = n / 2;
            }
        }
        public boolean less(int i , int j){
            int a = key[pq[i]].val;
            int b = key[pq[j]].val;
            if(a < b){
                return true;
            }
            else
                return false;
        }
        public void exch(int i , int j){
            int temp = pq[i];
            pq[i] = pq[j];
            pq[j] = temp;
        }
        public int minIndex(){
            return pq[1];
        }
        public ListNode delMin(){
            ListNode a = key[pq[1]];
            ListNode result = new ListNode(a.val);
            pq[1] = pq[n--];
            sink(1);
            return result;
        }
        public void sink(int i){
            while (2 * i <= n){
                int j = 2*i;
                if(j+1 <= n && less(j+1,j)){
                    j = j+1;
                }
                if(less(j,i)){
                    exch(j,i);
                    i = j;
                }
                else
                    break;
            }
        }
    }

    public static void main(String[] args) {
        MergekSortedLists a = new MergekSortedLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        ListNode result = a.mergeKLists(lists);
        int c = 2 ;
    }*/
    /*
    自下而上的归并排序。归并每进行一次，复杂度是O(n),一共要进行LOg(m)次。

     */
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0){
            return null;
        }
        for(int i = 1; i < lists.length; i= i + i){
            for(int j = 0; j + i< lists.length;j = j + 2 * i){
                lists[j] = merge(lists[j],lists[j+i]);
            }
        }
        return lists[0];
    }
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null || l2 != null){
            if(l1 == null){
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else if(l2 == null){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else if(l1.val < l2.val){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else{
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        return result.next;
    }
    public static void main(String[] args) {
        MergekSortedLists a = new MergekSortedLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        ListNode[] ss = new ListNode[0] ;
        ListNode result = a.mergeKLists(ss);
        int c = 2 ;
    }
}
