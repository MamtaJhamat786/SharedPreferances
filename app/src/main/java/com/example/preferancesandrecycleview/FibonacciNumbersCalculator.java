package com.example.preferancesandrecycleview;

import java.util.ArrayList;

public class FibonacciNumbersCalculator {

    public static ArrayList<Long> getNums(int count) {
        long first = 0;
        long second = 1;

        ArrayList<Long> list = new ArrayList<>(count);

        list.add(first);
        list.add(second);

        long prev = 0;
        long prev2 = 1;
        long current;
        for( int i = 2; i< count; ++i) {
            current = prev + prev2;
            list.add(current);
            prev = prev2;
            prev2 = current;
        }
        return list;
    }

}
