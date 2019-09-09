package Design;

import java.util.HashMap;

//使用双链表+hashmap
public class LRUCache {
    int size = 0;
    int capacity = 0;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    HashMap<Integer, Node> hashMap;

    private class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node next;
        Node pre;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Node x = hashMap.get(key);
            deleteNode(x);
            addHead(x);
            return x.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node cur = hashMap.get(key);
            cur.value = value;
            deleteNode(cur);
            addHead(cur);
            return;
        }
        if (size < capacity) {
            Node x = new Node(key, value);
            addHead(x);
            hashMap.put(key, x);
            size++;
        } else {
            Node x = new Node(key, value);
            deleteLast();
            addHead(x);
            hashMap.put(key, x);
        }
        return;
    }

    public void deleteNode(Node cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        cur.pre = null;
        cur.next = null;
    }

    public void addHead(Node current) {
        current.next = head.next;
        head.next.pre = current;
        current.pre = head;
        head.next = current;
    }

    public void deleteLast() {
        Node x = tail.pre;
        x.pre.next = tail;
        tail.pre = x.pre;
        hashMap.remove(x.key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

}
