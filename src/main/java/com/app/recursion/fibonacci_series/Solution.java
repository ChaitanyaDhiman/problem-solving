package com.app.recursion.fibonacci_series;

import java.util.stream.Stream;

public class Solution {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10; // Example input
        System.out.print("Fibonacci series up to " + n + ": ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println();
        //fibonacci series using streams
        System.out.print("Fibonacci series using streams up to " + n + ": ");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(n)
                .map(i -> i[0])
                .forEach(num -> System.out.print(num + " "));

    }

}
