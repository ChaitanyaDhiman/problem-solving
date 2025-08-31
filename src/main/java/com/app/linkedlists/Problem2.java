package com.app.linkedlists;

import java.util.HashSet;

//  Detect Cycle in Linked List
//
//  Given the head of a singly linked list, determine whether the list contains a cycle.
//
//  A cycle exists if, while traversing the list through next pointers, you encounter a node that has already been visited instead of eventually reaching nullptr.
//
//  Input: head: 1 -> 3 -> 4 -> 3
//  Output: true
//  Explanation: The last node of the linked list does not point to NULL; instead, it points to an earlier node in the list, creating a cycle.
//
//  Input: head: 1 -> 8 -> 3 -> 4 -> NULL
//  Output: false
//  Explanation: The last node of the linked list points to NULL, indicating the end of the list.
public class Problem2 {
    static Boolean detectLoop(Node head) {
        HashSet<Node> set = new HashSet<>();

        while (head != null) {
            // If this node is already present in hashset it means there is a cycle
            if (set.contains(head)) {
                return true;
            }
            // If we are seeing the node for the first time, insert it in hash
            set.add(head);
            head = head.next;
        }
        return false;
    }

    static boolean detectLoop2(Node head) {
        // fast and slow pointers initially points to the head
        Node slow = head, fast = head;

        // Loop that runs while fast and slow pointer are not null and not equal
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If fast and slow pointer points to the same node, then the cycle is detected
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;

        if(detectLoop(head)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
        System.out.println();

        if(detectLoop2(head)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}
