package com.app.interview_questions.car_rental_problem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RentalTime {
    private final Date start;
    private final Date end;

    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    @Override
    public String toString() {
        // Use a consistent format for printing the times (dd/MM/yyyy HH:mm)
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return "[" + formatter.format(start) + " - " + formatter.format(end) + "]";
    }
}
