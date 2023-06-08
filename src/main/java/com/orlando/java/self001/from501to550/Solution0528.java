package com.orlando.java.self001.from501to550;

import java.util.Random;

public class Solution0528 {

    private int[] preSum;
    private Random rand = new Random();
    public Solution0528(int[] w) {

        int n = w.length;
        preSum = new int[n];
        preSum[0] = w[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {

        int n = preSum.length;
        int target = rand.nextInt(preSum[n - 1]) + 1;
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] == target) return mid;
            else if (preSum[mid] < target) left = mid + 1;
            else if (preSum[mid] > target) right = mid;
        }
        return left;
    }
}

