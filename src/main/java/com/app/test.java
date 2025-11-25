package com.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class test {

    int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {

//        Map<Integer, Integer> map = new HashMap<>();
//
//        List<Integer> number = List.of(1, 2, 3, 4, 5);
//
//        Predicate<Integer> isEven = num -> num % 2 == 0;
//
//        System.out.println(isEven.test(4)); // true
//
//        Function<String, Integer> stringLength = str -> str.length();
//
//        System.out.println(stringLength.apply("Hello")); // 5
//
//        Consumer<String> printer = msg -> System.out.println(msg);
//
//        printer.accept("Hello");
//
//        Supplier<String> supplier = () -> "Hello";
//        System.out.println(supplier.get()); // Hello

        test t = new test();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = t.twoSum(nums, target);
        if (result.length > 0) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}
