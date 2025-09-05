<h2><a href="https://www.geeksforgeeks.org/dsa/trapping-rain-water/">Trapping Rain Water Problem</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>Given an array arr[] of size n consisting of non-negative integers, where each element represents the height of a bar in an elevation map and the width of each bar is 1, determine the total amount of water that can be trapped between the bars after it rains.</p>

![Alt text](https://media.geeksforgeeks.org/wp-content/uploads/20240613172631/Trapping-Rain-Water-Problem.png)

<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr[] = [3, 0, 1, 0, 4, 0, 2]
<strong>Output:</strong> 10
<strong>Explanation:</strong> The expected rainwater to be trapped is shown in the above image.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr[] = [3, 0, 2, 0, 4]
<strong>Output:</strong> 7
<strong>Explanation:</strong> We trap 0 + 3 + 1 + 3 + 0 = 7 units.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr[] = [1, 2, 3, 4]
<strong>Output:</strong> 0
<strong>Explanation:</strong> We cannot trap water as there is no height bound on both sides
</pre>