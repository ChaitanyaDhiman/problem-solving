<h2><a href="">Session Validation</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are debugging a customer report where an online session misbehaved. You're given a simplified log of events from a single session. Each line in the log follows the format.</p>

&lt;TIMESTAMP&gt; &lt;EVENT_TYPE&gt;

<p>TIMESTAMP: integer in milliseconds</p>
EVENT_TYPE: is one of the following: 
<strong>START, ACTION, ERROR, or END</strong>

<p>A session is valid only if: START is the first event and END is the last.</p>

<p>All the timestamps are strictly increasing.</p>

<p>There's at least one ACTION between START and END</p>

<p>No duplicate non-ACTION events (i.e., at most one START, END, ERROR each).</p>

<p>An ERROR must be followed by at least one ACTION before the session ends</p>

<p>The session duration (END - START) must not exceed 60,000 ms.</p>

<p><strong>Your task is to implement the method :</strong></p>

<pre>
public Boolean isValidSession(List&lt;String&gt; logs) 
</pre>

<p>where "logs" are log entries with the format mentioned above.</p>
Return true if the session is valid according to the rules above. Otherwise, return false.

<pre>
<strong>Examples : </strong>
isValidSession(List.of(
"100 START",
"200 ACTION",
"300 ERROR",
"400 ACTION",
"1000 END"
<strong>Output : true</strong>
</pre>