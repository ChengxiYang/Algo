package Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Your Hash.LRUCache object will be instantiated and called as such:
 * Hash.LRUCache obj = new Hash.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * @author chengxiyang
 */

public class LRUCache {

    //双向链表节点
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

    Node head;

    Node tail;

    int capacity;

    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int ret = node.value;
        moveToTail(node);
        return ret;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
            return;
        }

        //头节点为最久未使用节点，执行驱逐
        if (map.size() == capacity) {
            map.remove(head.key);
            deleteHead();
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;

        addToTail(newNode);
        map.put(key, newNode);

    }

    void addToTail(Node node) {
        if (head == null && tail == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    void deleteHead() {
        if (head == tail) {
            head = null;
            tail = null;
        } else{
            Node tmp = head.next;
            tmp.prev = null;
            head.next = null;
            head = tmp;
        }
    }

    void moveToTail(Node node) {
        if (node == tail) {
            return;
        }
        if (node == head) {
            head = node.next;
            head.prev = null;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }
}
