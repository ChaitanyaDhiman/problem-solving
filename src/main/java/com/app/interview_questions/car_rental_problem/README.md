<h2><a href="">Car Rental</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>A new car-share app allows users to schedule a time to rent a specific car. Given a collection of car rental times, implement the <strong>canScheduleAll</strong> method which, <strong>efficiently</strong> with respect to time and space used, checks if all rental times can be scheduled, without having two or more overlaps.</p>
For example, for the rental times below, the method should return true because they don't overlap: 

<p>3/5/2023 19:00-20:30</p>
<p>3/5/2023 22:10-22:30</p>
<p>3/5/2023 20:30-22:00</p>

<strong>Note:</strong> during the task use the below RentalTime class.
<pre>
class RentalTime {
    private Date start, end;

    public RentalTime(v start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}
</pre>

[//]: # (<p><strong class="example">Example 1:</strong></p>)

[//]: # ()
[//]: # (<pre>)

[//]: # (<strong>Input:</strong> a[] = [11, 1, 13, 21, 3, 7], b[] = [11, 3, 7, 1] )

[//]: # (<strong>Output:</strong> true)

[//]: # (</pre>)

[//]: # ()
[//]: # (<p><strong class="example">Example 2:</strong></p>)

[//]: # ()
[//]: # (<pre>)

[//]: # (<strong>Input:</strong> a[]= [1, 2, 3, 4, 5, 6], b = [1, 2, 4] )

[//]: # (<strong>Output:</strong> true)

[//]: # (</pre>)

[//]: # ()
[//]: # (<p><strong class="example">Example 3:</strong></p>)

[//]: # ()
[//]: # (<pre>)

[//]: # (<strong>Input:</strong> a[] = [10, 5, 2, 23, 19], b = [19, 5, 3]  )

[//]: # (<strong>Output:</strong> false)

[//]: # (</pre>)
