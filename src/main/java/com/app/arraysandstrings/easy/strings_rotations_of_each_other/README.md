<h2><a href="https://www.geeksforgeeks.org/dsa/a-program-to-check-if-strings-are-rotations-of-each-other/#expected-approach-using-pattern-matching-on-time-and-on-space">Check if Strings Are Rotations of Each Other</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given two strings s1 and s2 of equal length, determine whether s2 is a rotation of s1.
A string is said to be a rotation of another if it can be obtained by shifting some leading characters of the original string to its end without changing the order of characters.</p>


<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s1 = "abcd", s2 = "cdab"
<strong>Output:</strong> true
<strong>Explanation:</strong> After 2 right rotations, s1 will become equal to s2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s1 = "aab", s2 = "aba"
<strong>Output:</strong> true
<strong>Explanation:</strong> After 1 left rotation, s1 will become equal to s2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s1 = "abcd", s2 = "acbd"
<strong>Output:</strong> false
<strong>Explanation:</strong> Strings are not rotations of each other.
</pre>

