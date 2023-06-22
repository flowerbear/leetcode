package com.orlando.java.self001.from851to900;

public class Solution0875 {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1_000_000_000;
        while (l < r) {
            int m = l + (r - l) / 2, total = 0;
            for (int p : piles) {
                total += (p + m - 1) / m;
            }
            if (total > h) l = m + 1;
            else r = m;
        }
        return l;
    }
}

