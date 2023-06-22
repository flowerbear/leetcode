package com.orlando.java.self001.from2051to2100;

import java.util.Arrays;

public class Solution2090 {

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 1; i < preSum.length; i++) preSum[i] = preSum[i - 1] + (long)nums[i - 1];
        for (int i = k; i + k < n; i++) {
            res[i] = (int)(preSum[i + k + 1] - preSum[i - k]) / (2 * k + 1);

        }
        return res;
    }
}
