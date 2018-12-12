package Linked_list;

public class Design_Linked_List {
    int size;
    ListNode head;
    ListNode tail;

    /**
     * Initialize your data structure here.
     */
    public Design_Linked_List() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        int k = 0;
        ListNode temp = head;
        while (k < index) {
            temp = temp.next;
            k++;
        }
        return temp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        temp.next = head;
        head = temp;
        size++;
        if (size == 1) {
            tail = head;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (size == 0) {
            tail = new ListNode(val);
            head = tail;
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        int k = 0;
        ListNode temp = head;
        while (k < index) {
            temp = temp.next;
            k++;
        }
        if (temp == null) {
            addAtTail(val);
        } else {
            ListNode x = new ListNode(temp.val);
            x.next = temp.next;
            temp.next = x;
            temp.val = val;
            if (x.next == null) {
                tail = x;
            }
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        if (index == size - 1) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                int k = 0;
                ListNode temp = head;
                while (k < index - 1) {
                    temp = temp.next;
                    k++;
                }
                temp.next = null;
                tail = temp;
            }
            size--;
            return;
        }
        int k = 0;
        ListNode temp = head;
        while (k < index) {
            temp = temp.next;
            k++;
        }
        if (temp.next == null) {
            tail = temp;
        } else {
            temp.val = temp.next.val;
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
        size--;
    }

    public static void main(String[] args) {
        Design_Linked_List linkedList = new Design_Linked_List();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);

        linkedList.addAtIndex(3, 0);  // linked list becomes 1->2->3
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        linkedList.get(4);
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
