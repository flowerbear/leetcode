package com.orlando.java.self001.from651to700;

public class Solution0670 {

    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int n = chars.length, maxIdx = n - 1;
        // larger: rightmost largest digit of all numbers
        // smaller: first smaller number to the left of maxIdx
        int larger = 0, smaller = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (chars[i] > chars[maxIdx]) maxIdx = i;
            else if (chars[i] < chars[maxIdx]) {
                smaller = i;
                larger = maxIdx;
            }
        }

        char temp = chars[larger];
        chars[larger] = chars[smaller];
        chars[smaller] = temp;
        return Integer.valueOf(String.valueOf(chars));
    }
}

