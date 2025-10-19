<h2><a href="https://www.geeksforgeeks.org/dsa/maximum-sum-submatrix/">Maximum sum sub-matrix</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Write a method that, given a 2D matrix of integers, finds the sub-matrix with the largest sum.</p>
If multiple sub-matrices have the same largest sum, choose the one with the smallest area (i.e, fewest cells).
If there is still a tie, prefer the sub-matrix that starts at the topmost row, and if still tied, at the leftmost column.

<p>Return only the sum of the chosen sub-matrix.</p>
<p>You may assume the matrix has at least one row and one column.</p>

<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> int[][] matrix = {
    {1, 2, -1},
    {-3, 4, 5},
    {2, -1, -2}
};
<strong>Output:</strong> 10
<strong>Explanation:</strong> The sub-matrix:<p>2 -1
4 5</p><p>(rows 0-1, column 1-2)</p><p>has sum = 10, which is the largest possible.</p><p>Area : 4 cells, which is the smallest among candidates with sum = 10.</p>
</pre>

