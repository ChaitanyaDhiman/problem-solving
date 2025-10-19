package com.app.interview_questions.session_validation_problem;

import java.util.List;

public class Solution {
    public Boolean isValidSession(List<String> logs) {
        if (logs == null || logs.isEmpty()) {
            return false;
        }

        long startTime = -1;
        long endTime = -1;
        int actionCount = 0;
        boolean hasStart = false;
        boolean hasEnd = false;
        boolean hasError = false;

        long lastTimestamp = -1;

        int startCount = 0;
        int endCount = 0;
        int errorCount = 0;

        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            long currentTimestamp = Long.parseLong(log.split(" ")[0]);
            String eventType = parseEventType(log);

            if (currentTimestamp <= lastTimestamp) {
                return false; // Timestamps must be non-decreasing
            }
            lastTimestamp = currentTimestamp;

            switch (eventType) {
                case "START":
                    startCount++;
                    if (startCount > 1 || i != 0) { return false; }

                    hasStart = true;
                    startTime = currentTimestamp;
                    break;
                case "END":
                    endCount++;
                    if (endCount > 1 || i != logs.size() - 1) { return false; }

                    hasEnd = true;
                    endTime = currentTimestamp;
                    break;
                case "ACTION":
                    actionCount++;
                    if (hasError) { hasError = false; }
                    break;
                case "ERROR":
                    errorCount++;
                    if (errorCount > 1) { return false; }

                    hasError = true;
                    break;
                default:
                    return false; // Invalid event type
            }
        }
        if (!hasStart || !hasEnd) {
            return false; // Must have exactly one START and one END
        }
        if (actionCount < 1) {
            return false; // Must have at least one ACTION
        }
        if (hasError) {
            return false;
        }
        if (endTime - startTime > 60000) {
            return false;
        }

        return true;
    }

    private String parseEventType(String log) {
        String[] parts = log.split(" ");
        if (parts.length < 2) { return ""; }
        return parts[1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> logs = List.of(
            "1000 START",
            "2000 ACTION",
            "3000 ACTION",
            "4000 END"
        );
        Boolean result = solution.isValidSession(logs);
        System.out.println("Is valid session: " + result); // Expected: true
    }
}
