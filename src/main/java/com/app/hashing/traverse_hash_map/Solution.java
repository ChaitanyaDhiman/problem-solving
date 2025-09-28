package com.app.hashing.traverse_hash_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    // 1. Using entrySet() with a for-each loop (Recommended for keys and values)
    public static void printMap1(HashMap<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    // 2. Using keySet() with a for-each loop (For keys only)
    public static void printMap2(HashMap<Integer, Integer> map) {
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }
    // 3. Using values() with a for-each loop (For values only)
    public static void printMap3(HashMap<Integer, Integer> map) {
        for (Integer value : map.values()) {
            System.out.println("Value:  " + value);
        }
    }
    // 4. Using Iterator with entrySet()
    public static void printMap4(HashMap<Integer, Integer> map) {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    // 5. Using Java 8 forEach() with lambda expression
    public static void printMap5(HashMap<Integer, Integer> map) {
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 3);
        map.put(3, 5);

        printMap1(map);
        printMap2(map);
        printMap3(map);
        printMap4(map);
        printMap5(map);
    }
}
