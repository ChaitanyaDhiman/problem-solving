<h2><a href="https://www.geeksforgeeks.org/dsa/next-permutation/">Next Permutation</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given an array of integers arr[] representing a permutation (i.e., all elements are unique and arranged in some order), find the next lexicographically greater permutation by rearranging the elements of the array.
If such a permutation does not exist (i.e., the array is the last possible permutation), rearrange the elements to form the lowest possible order (i.e., sorted in ascending order).</p>


<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr[] = [2, 4, 1, 7, 5, 0]
<strong>Output:</strong> [2, 4, 5, 0, 1, 7]
<strong>Explanation:</strong> The next lexicographically greater arrangement of the elements in the array arr[] is [2, 4, 5, 0, 1, 7].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr[] = [3, 2, 1]
<strong>Output:</strong> [1, 2, 3]
<strong>Explanation:</strong> This is the last permutation, so we return the lowest possible permutation (ascending order).
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr[] = [1, 3, 5, 4, 2]
<strong>Output:</strong> [1, 4, 2, 3, 5]
<strong>Explanation:</strong> The next lexicographically greater arrangement of the elements in the array arr[] is [1, 4, 2, 3, 5].
</pre>