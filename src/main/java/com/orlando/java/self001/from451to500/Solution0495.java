package com.orlando.java.self001.from451to500;

public class Solution0495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            int diff = timeSeries[i] - timeSeries[i - 1];
            if (diff < duration) count += diff;
            else count += duration;
        }
        return count;
    }
}

