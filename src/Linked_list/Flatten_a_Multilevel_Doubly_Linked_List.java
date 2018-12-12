package Linked_list;

public class Flatten_a_Multilevel_Doubly_Linked_List {
    public Node flatten(Node head) {
        Node result = head;
        while (head != null) {
            if (head.child != null) {
                Node nextHead = head.next;
                Node child = head.child;
                head.child = null;
                head.next = flatten(child);
                head.next.prev = head;
                while (head.next != null) {
                    head = head.next;
                }
                head.next = nextHead;
                if (nextHead != null)
                    nextHead.prev = head;
                head = nextHead;
            } else {
                head = head.next;
            }
        }
        return result;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};