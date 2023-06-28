package com.orlando.java.self001.from851to900;

import java.util.Arrays;

public class Solution0881 {


    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum <= limit) {
                res++;
                left++; right--;
            } else {
                res++;
                right--;
            }
        }
        return res;
    }
}

