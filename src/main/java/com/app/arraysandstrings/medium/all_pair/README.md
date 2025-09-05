<h2><a href="https://www.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/1">Find all pairs with a given sum</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given two unsorted arrays a[]  and b[], the task is to find all pairs whose sum equals x from both arrays.

Note: All pairs should be returned in increasing order of u. For eg. for two pairs (u1,v1) and (u2,v2), if u1 < u2 then (u1,v1) should be returned first else second.</p>


<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> target = 9, a[] = [1, 2, 4, 5, 7], b[] = [5, 6, 3, 4, 8]
<strong>Output:</strong> 
1 8
4 5 
5 4
<strong>Explanation:</strong> (1, 8), (4, 5), (5, 4) are the pairs which sum to 9.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> target = 8, a[] = [-1, -2, 4, -6, 5, 7], b[] = [6, 3, 4, 0]
<strong>Output:</strong> 4 4 
5 3
</pre>


<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> target = 9, a[] = [1, 2, 4, 5, 7, 4], b[] = [5, 6, 3, 4, 8, 4]
<strong>Output:</strong> 
1 8
4 5
4 5
5 4
5 4
<strong>Explanation:</strong> (1, 8), (4, 5), (4, 5), (5, 4) and (5, 4) are the pairs which sum to 9.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr1.size, arr2.size &lt;= 10<sup>5</sup></code></li>
	<li><code>-2<sup>*</sup>10<sup>4</sup> &lt;= target, arr1[i], arr2[i] &lt;= 2<sup>*</sup>10<sup>4</sup></code></li>
</ul>