package com.coding.topics.ds_design.revision;

import com.coding.topics.ds_design.CustomHashMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMapImpl {

    int capacity;
    List<LinkedList<Pair>> list;

    public HashMapImpl(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>();

        for (int i = 0; i < this.capacity; i++) {
            list.add(new LinkedList<>());
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    private int get(int key) {
        int hash = hash(key);
        LinkedList<Pair> pairs = list.get(hash);
        if (pairs != null) {
            for (Pair pair : pairs) {
                if (pair.key == key) {
                    return pair.value;
                }
            }
        }
        return -1;
    }

    private void put(int key, int value) {
        int hash = hash(key);
        LinkedList<Pair> pairs = list.get(hash);
        if (pairs.isEmpty()) {
            pairs = new LinkedList<>();
            pairs.add(new Pair(key, value));
            list.set(hash, pairs);
        } else {
            for (Pair pair : pairs) {
                if (pair.key == key) {
                    pair.value = value;
                }
            }
        }
    }

    private void remove(int key) {
        int hash = hash(key);
        LinkedList<Pair> pairs = list.get(hash);
        if (pairs != null) {
            for (Pair pair : pairs) {
                if (pair.key == key) {
                    pairs.remove(pair);
                }
            }
        }
    }

    static class Pair {
        int key;
        int value;
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMapImpl myHashMap = new HashMapImpl(1000);
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}
