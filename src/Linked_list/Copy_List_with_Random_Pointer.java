package Linked_list;

public class Copy_List_with_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode index = head;
        while (index != null) {
            RandomListNode x = new RandomListNode(index.label);
            x.next = index.next;
            index.next = x;
            index = index.next.next;
        }
        index = head;
        while (index != null) {
            if (index.random != null)
                index.next.random = index.random.next;
            index = index.next.next;
        }
        index = head;
        RandomListNode result = new RandomListNode(-1);
        RandomListNode tmp = result;
        while (index != null) {
            tmp.next = index.next;
            index.next = index.next.next;
            tmp = tmp.next;
            index = index.next;
        }
        return result.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};