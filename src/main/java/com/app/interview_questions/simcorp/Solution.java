package com.app.interview_questions.simcorp;

//id batch   name	output	user	 date
//2	 abc	 Yahoo	120	 	test	 2024-05-02
//3	 abc	 Google	130	 	test	 2024-05-02
//4	 abc	 TATA	130	 	test	 2024-05-02
//5	 xyz	 Yahoo	123	 	test	 2024-05-03
//6	 xyz	 Google	133	 	test	 2024-05-03
//7	 xyz	 Apple	133	 	test	 2024-05-03
//8	 def	 Yahoo	125	 	dev	     2024-05-04
//9	 def	 Google	135	 	dev	     2024-05-04

//Question 1
//Give the latest result of "Google" for the user "test"
//
//Question 2
//Give the latest results for all names for user "test"

//This question was asked in SimCorp interview.

import java.util.*;

public class Solution {

    private int id;
    private String batch;
    private String name;
    private int output;
    private String user;
    private Date date;

    public Solution() {

    }

    public Solution(int id, String batch, String name, int output, String user, Date date) {
        this.id = id;
        this.batch = batch;
        this.name = name;
        this.output = output;
        this.user = user;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        return String.format("id=%d, batch=%s, name=%s, output=%d, user=%s, date=%s%n",
                this.id, this.batch, this.name, this.output, this.user, this.date);
    }

    public static void main(String[] args) {
        // Implementation of data retrieval logic would go here

        Solution s = new Solution();

        List<Solution> table = new ArrayList<>();
        table.add(new Solution(2, "abc", "Yahoo", 120, "test", new Date(2024, Calendar.MAY, 2)));
        table.add(new Solution(3, "abc", "Google", 130, "test", new Date(2024, Calendar.MAY, 2)));
        table.add(new Solution(4, "abc", "TATA", 130, "test", new Date(2024, Calendar.MAY, 2)));
        table.add(new Solution(5, "xyz", "Yahoo", 123, "test", new Date(2024, Calendar.MAY, 3 )));
        table.add(new Solution(6, "xyz", "Google", 133, "test", new Date(2024, Calendar.MAY, 3 )));
        table.add(new Solution(7, "xyz", "Apple", 133, "test", new Date(2024, Calendar.MAY, 3 )));
        table.add(new Solution(8, "def", "Yahoo", 125, "dev", new Date(2024, Calendar.MAY, 4 )));
        table.add(new Solution(9, "def", "Google", 135, "dev", new Date(2024, Calendar.MAY, 4 )));


        List<Solution> result1 = table
                .stream()
                .filter( n -> n.getName().equals("Google") && n.getUser().equals("test"))
                .max(Comparator.comparing(Solution::getDate))
                .stream()
                .toList();

        System.out.println("Latest result of Google for user test: " + result1.toString());


        List<Solution> result2 = table
                .stream()
                .filter( n -> n.getUser().equals("test"))
                .collect(
                        HashMap<String, Solution>::new,
                        (map, entry) -> {
                            if (!map.containsKey(entry.getName()) ||
                                    map.get(entry.getName()).getDate().before(entry.getDate())) {
                                map.put(entry.getName(), entry);
                            }
                        },
                        HashMap<String, Solution>::putAll
                )
                .values()
                .stream()
                .toList();

        System.out.println("Latest results for all names for user test: " + result2.toString());

    }
}
