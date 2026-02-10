package com.app.streamingAPI;

import java.util.*;
import java.util.stream.Collectors;

public class streamAPI {
    public static void main(String[] args) {
        //Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
        List<Integer> numbers = Arrays.asList(10,15,8,49,25,98,32);

        System.out.println("Even numbers in the list: ");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        //Find the second-highest number in a list of integers.
        Optional<Integer> secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        System.out.println("Second highest number in the list: " + secondHighest.orElse(null));

        //Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);

        System.out.println("Numbers starting with 1 in the list: ");
        myList.stream()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);

        //How to find duplicate elements in a given integers list in java using Stream functions?
        List<Integer> myList2 = Arrays.asList(10,15,8,49,25,98,98,32,15);

        System.out.println("Duplicate numbers in the list: ");
        Set<Integer> set = new HashSet<>();
        myList2.stream()
                .filter(n -> !set.add(n))
                .forEach(System.out::println);

        //Given the list of integers, find the first element of the list using Stream functions?

        List<Integer> myList3 = Arrays.asList(10,15,8,49,25,98,32);

        System.out.println("First element of the list: ");
        myList3.stream()
                .findFirst()
                .ifPresent(System.out::println);

        //Given a list of integers, find the total number of elements present in the list using Stream functions?
        List<Integer> myList4 = Arrays.asList(10,15,8,49,25,98,32);

        long count = myList4
                .stream()
                .count();
        System.out.println("Total number of elements in the list: " + count);

        //Given a list of integers, find the maximum value element present in it using Stream functions?
        int max = myList4.stream()
                .max(Integer::compare)
                .get();

        System.out.println("Maximum value element in the list: " + max);

        //Given a String, find the first non-repeated character in it using Stream functions?
        String input = "Java articles are Awesome";

        Character result = input.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch))
                .findFirst().orElse(null);

        System.out.println("First non-repeated character: " + result);

        //Given a String, find the first repeated character in it using Stream functions?
        Character repeatedChar = input.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .filter(ch -> input.indexOf(ch) != input.lastIndexOf(ch))
                .findFirst().orElse(null);

        System.out.println("First repeated character: " + repeatedChar);

        //Given a list of integers, sort all the values present in it using Stream functions?
        List<Integer> myList5 = Arrays.asList(10,15,8,49,25,98,32);

        System.out.println("Sorted list of integers: ");
        myList5.stream()
                .sorted()
                .forEach(System.out::println);

        //Given a list of integers, sort all the values present in it in descending order using Stream functions?
        System.out.println("Sorted list of integers in descending order: ");
        myList5.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        //Given an integer array arrays, return true if any value appears at least twice in the array, and return false if every element is distinct.
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1};

        boolean hasDuplicates = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toSet())
                .size() < array.length;

        System.out.println("Does the array contain duplicates? " + hasDuplicates);
    }


}
