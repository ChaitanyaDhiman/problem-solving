package com.app.customMapImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// This was asked in MasterCard Interview.

public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int size; // Tracks the number of key-value pairs
    private int putCount; // Tracks the number of successful put operations
    private int getCount; // Tracks the number of successful get operations

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        // Initialize the array of LinkedLists
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
        this.size = 0;
        this.putCount = 0;
        this.getCount = 0;
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Simple hash function
    private int hash(K key) {
        // Use the built-in hashCode and modulo to get an index within the table's bounds
        return Math.abs(key.hashCode() % table.length);
    }

    /**
     * Inserts or updates a key-value pair.
     * @param key The key to insert or update.
     * @param value The value associated with the key.
     * @return The previous value associated with the key, or null if the key was new.
     */
    public V put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // 1. Check if the key already exists (update)
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value; // Update the value
                this.putCount++; // Successful update counts as a put operation
                return oldValue;
            }
        }

        // 2. Key does not exist (insert new entry)
        bucket.add(new Entry<>(key, value));
        this.size++;
        this.putCount++; // Successful insertion counts as a put operation

        // In a production-level map, you'd check for load factor and resize here.
        return null; // No previous value
    }

    /**
     * Retrieves the value associated with the key.
     * @param key The key whose associated value is to be returned.
     * @return The value associated with the key, or null if the key is not found.
     */
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Search the linked list (bucket) for the key
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                this.getCount++; // Successful retrieval
                return entry.value;
            }
        }

        return null; // Key not found
    }

    /**
     * Finds the size of the CustomHashMap (total number of key-value mappings).
     * This is the standard name for the method in Java's Map interface.
     * @return The number of key-value mappings in this map.
     */
    public int size() {
        return this.size;
    }

    /**
     * @return The total number of successful put (insert or update) operations.
     */
    public int getPutCount() {
        return this.putCount;
    }

    /**
     * @return The total number of successful get operations (key found).
     */
    public int getGetCount() {
        return this.getCount;
    }

    /**
     * Returns a List of all keys in the map, represented as Strings.
     * @return A List<String> containing all keys.
     */
    public List<String> keysAsString() {
        List<String> keyList = new ArrayList<>();
        // Iterate through the entire table array
        for (LinkedList<Entry<K, V>> bucket : table) {
            // Iterate through the linked list in each bucket
            for (Entry<K, V> entry : bucket) {
                keyList.add(entry.key.toString());
            }
        }
        return keyList;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> customMap = new CustomHashMap<>();

        customMap.put("a", 1);
        customMap.put("b", 2);
        customMap.put("c", 3);

        System.out.println("Value for 'a': " + customMap.get("a")); // Should print 2
        System.out.println("Value for 'd': " + customMap.get("d")); // Should print null

        customMap.put("b", 22); // Update value for key "Two"
        System.out.println("Updated Value for 'b': " + customMap.get("b")); // Should print 22

        System.out.println("Size of map: " + customMap.size()); // Should print 3
        System.out.println("Put operations count: " + customMap.getPutCount()); // Should print 4
        System.out.println("Get operations count: " + customMap.getGetCount()); // Should print 3

        System.out.println("Keys in map: " + customMap.keysAsString()); // Should print keys as strings

        assert List.of("One", "Two", "Three").equals(customMap.keysAsString());
    }

}
