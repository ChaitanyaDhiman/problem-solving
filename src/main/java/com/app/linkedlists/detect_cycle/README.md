<h2><a href="https://www.geeksforgeeks.org/dsa/detect-loop-in-a-linked-list/">Detect Cycle in Linked List</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given the head of a singly linked list, determine whether the list contains a cycle.</p>

<p>A cycle exists if, while traversing the list through next pointers, you encounter a node that has already been visited instead of eventually reaching nullptr.</p>

<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> head: 1 -> 3 -> 4 -> 3
<strong>Output:</strong> true
<strong>Explanation:</strong> The last node of the linked list does not point to NULL; instead, it points to an earlier node in the list, creating a cycle.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> 1 -> 8 -> 3 -> 4 -> NULL
<strong>Output:</strong> false
<strong>Explanation:</strong> The last node of the linked list points to NULL, indicating the end of the list.
</pre>

