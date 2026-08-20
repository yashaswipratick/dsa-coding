package com.coding.topics.ds_design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> cache = new HashMap<>();
    Node head = new Node(-1, -1); 
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToFront(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        evict();
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToFront(node);
            node.value = value;
        } else {
            Node node = new Node(key, value);
            cache.put(key, node);
            moveToFront(node);
            capacity--;
        }
    }
    
    public int remove(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            cache.remove(key);
            removeNode(node);
            capacity++;
            return node.value;
        } else {
            return -1;
        }
    }
    
    public int size() {
        return cache.size();
    }
    
    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void evict() {
        if (cache.size() > capacity) {
            removeFromLast();
        }
    }

    private void removeFromLast() {
        Node lru = tail.prev;   // last real node
        if (lru == head) return; // nothing to evict
        removeNode(lru);
        cache.remove(lru.key);
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        //If there was already a node after head, update that node’s prev pointer to point back to the new node.
        if (head.next != null) {
            head.next.prev = node;
        }
        head.next = node;
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
    
    public void clear() {
        cache.clear();
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        expect("get(1)", 1, cache.get(1));

        cache.put(3, 3); // should evict key 2 in a correct LRU
        expect("get(2) after put(3)", -1, cache.get(2));

        cache.put(4, 4); // should evict key 1 in a correct LRU
        expect("get(1) after put(4)", -1, cache.get(1));
        expect("get(3)", 3, cache.get(3));
        expect("get(4)", 4, cache.get(4));

        cache.put(4, 40); // update existing
        expect("get(4) after update", 40, cache.get(4));

        int removed = cache.remove(3);
        expect("remove(3)", 3, removed);
        expect("size() after remove(3)", 1, cache.size());

        cache.clear();
        expect("size() after clear", 0, cache.size());
        expect("get(4) after clear", -1, cache.get(4));
    }

    private static void expect(String label, int expected, int actual) {
        String status = expected == actual ? "PASS" : "FAIL";
        System.out.println(status + " | " + label + " | expected=" + expected + ", actual=" + actual);
    }
    
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
