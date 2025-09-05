package com.app.linkedlists.rotate_linked_list;

import com.app.linkedlists.Node;

public class Solution {
    // Using HashSet - O(n) Time and O(n) Space
    static Node rotate(Node head, int k) {
        if(k == 0 || head == null) return head;

        Node current = head;
        int length = 1;

        // Find the length of linked list
        while(current.next != null) {
            current = current.next;
            length++;
        }
        // modulo k with length of linked list to handle large values of k
        k %= length;
        if(k == 0) return head;

        // make the linked list circular
        current.next = head;

        // traverse the linked list to find the kth node
        current = head;
        for (int i = 1; i < k; i++)
            current = current.next;

        // update the (k+1)th node as the new head
        head = current.next;

        // break the loop by updating next pointer of the kth node
        current.next = null;
        return head;
    }

    // Using Floyd's Cycle-Finding Algorithm
    static void pintList(Node head) {
        while(head != null) {
            System.out.print(head.data);
            if(head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        head = rotate(head, 6);
        pintList(head);
    }
}
