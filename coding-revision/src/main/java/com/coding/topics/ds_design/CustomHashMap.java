package com.coding.topics.ds_design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashMap {

    List<LinkedList<Pair>> list;
    int capacity;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;

        this.list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            list.add(new LinkedList<>());
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    public int get(int key) {
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

    public void put(int key, int value) {
        int hash = hash(key);
        LinkedList<Pair> pairs = list.get(hash);
        if (pairs == null) {
            pairs = new LinkedList<>();
            pairs.add(new Pair(key, value));
            list.set(hash, pairs);
        } else {
            for (Pair pair : pairs) {
                if (pair.key == key) {
                    pair.value = value;
                }
            }
           pairs.add(new Pair(key, value));
        }
    }

    public void remove(int key) {
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

    public int size() {
        return list.size();
    }

    static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        CustomHashMap myHashMap = new CustomHashMap(1000);
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
