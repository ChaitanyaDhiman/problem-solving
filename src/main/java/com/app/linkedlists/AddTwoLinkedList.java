package com.app.linkedlists;

//  Add Two Numbers in a Linked List
//
//  Given two non-negative integers represented as linked lists with heads head1 and head2, where each node contains a single digit,
//  return a new linked list representing their sum.
//
//  Note: The input lists may contain leading zeros, but the resulting sum list must not contain any leading zeros.
public class AddTwoLinkedList {

    // Function to trim leading zeros in linked list
    static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    // Function to reverse linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to add 2 linked lists
    static Node addTwoLists(Node l1, Node l2) {
        Node res = null;
        Node curr = null;
        int carry = 0;

        l1 = trimLeadingZeros(l1);
        l2 = trimLeadingZeros(l2);

        l1 = reverse(l1);
        l2 = reverse(l2);

        // Iterate till either l1 != empty or l2 != empty or carry > 0
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            Node newNode = new Node(sum % 10);

            carry = sum / 10;

            // If this is the first node, then make this node as the head of the resultant linked list
            if (res == null) {
                res = newNode;
                curr = newNode;
            } else {
                // Append new node to resultant linked list and move to the next node
                curr.next = newNode;
                curr = curr.next;
            }
        }
        return reverse(res);
    }

    // Function to print linked list
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);

        Node l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(9);

        Node sum = addTwoLists(l1, l2);
        printList(sum);
    }
}
