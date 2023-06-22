package com.orlando.java.self001.from1701to1750;

public class Solution1732 {

    public int largestAltitude(int[] gain) {
        int max = 0, curr = 0;
        for (int n : gain) {
            curr += n;
            max = Math.max(max, curr);
        }

        return max;
    }
}
