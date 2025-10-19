package com.app.interview_questions.car_rental_problem;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Solution {
    public boolean canScheduleAll(Collection<RentalTime> rentalTimes) {
        if (rentalTimes == null || rentalTimes.size() <= 1) {
            return true;
        }

        List<RentalTime> sortedRentals = new ArrayList<>(rentalTimes);

        Collections.sort(sortedRentals, new Comparator<RentalTime>() {
            @Override
            public int compare(RentalTime o1, RentalTime o2) {
                return o1.getStart().compareTo(o2.getStart());
            }
        });

        for (int i = 1; i < sortedRentals.size(); i++) {
            RentalTime currentRental = sortedRentals.get(i);
            RentalTime previousRental = sortedRentals.get(i);

            if (currentRental.getStart().before(previousRental.getEnd())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        // Use SimpleDateFormat to easily create Date objects from strings with format dd/MM/yyyy HH:mm
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            // --- Test Case 1: Non-overlapping (The example from the prompt) ---
            // Dates are now in dd/MM/yyyy format
            Date start1 = sdf.parse("05/03/2023 19:00");
            Date end1 = sdf.parse("05/03/2023 20:30");

            Date start2 = sdf.parse("05/03/2023 22:10");
            Date end2 = sdf.parse("05/03/2023 22:30");

            Date start3 = sdf.parse("05/03/2023 20:30"); // Starts exactly at the end of rent1
            Date end3 = sdf.parse("05/03/2023 22:00");

            List<RentalTime> case1 = new ArrayList<>();
            case1.add(new RentalTime(start1, end1));
            case1.add(new RentalTime(start2, end2));
            case1.add(new RentalTime(start3, end3));

            System.out.println("--- Test Case 1: Non-overlapping (Expected: true) ---");
            System.out.println("Rentals:");
            for (RentalTime rental : case1) {
                System.out.println("  - " + rental);
            }
            boolean result1 = solver.canScheduleAll(case1);
            System.out.println("Result: " + result1);
            System.out.println("-----------------------------------------------------");


            // --- Test Case 2: Overlapping ---
            // Rent4 (10:00 - 11:30) overlaps with Rent5 (11:00 - 12:00)
            Date start4 = sdf.parse("06/03/2023 10:00");
            Date end4 = sdf.parse("06/03/2023 11:30");

            Date start5 = sdf.parse("06/03/2023 11:00");
            Date end5 = sdf.parse("06/03/2023 12:00");

            Date start6 = sdf.parse("06/03/2023 13:00");
            Date end6 = sdf.parse("06/03/2023 14:00");

            List<RentalTime> case2 = new ArrayList<>();
            case2.add(new RentalTime(start4, end4));
            case2.add(new RentalTime(start5, end5));
            case2.add(new RentalTime(start6, end6));

            System.out.println("--- Test Case 2: Overlapping (Expected: false) ---");
            System.out.println("Rentals:");
            for (RentalTime rental : case2) {
                System.out.println("  - " + rental);
            }
            boolean result2 = solver.canScheduleAll(case2);
            System.out.println("Result: " + result2);
            System.out.println("-----------------------------------------------------");

            // --- Test Case 3: Empty List (Edge Case) ---
            System.out.println("--- Test Case 3: Empty List (Expected: true) ---");
            boolean result3 = solver.canScheduleAll(new ArrayList<>());
            System.out.println("Result: " + result3);
            System.out.println("-----------------------------------------------------");

        } catch (Exception e) {
            System.err.println("An error occurred during date parsing or execution: " + e.getMessage());
        }
    }
}
