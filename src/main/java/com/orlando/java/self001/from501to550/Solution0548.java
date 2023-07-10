package com.orlando.java.self001.from501to550;

import java.util.HashSet;

public class Solution0548 {

    public boolean splitArray(int[] nums) {
        int n = nums.length;
        if (n < 7) return false;

        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        for (int j = 3; j < n - 3; j++) {
            HashSet<Integer> seen = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (preSum[i - 1] == preSum[j - 1] - preSum[i]) seen.add(preSum[i - 1]);
            }
            for (int k = j + 2; k < n - 1; k++) {
                if (preSum[n - 1] - preSum[k] == preSum[k - 1] - preSum[j] && seen.contains(preSum[k - 1] - preSum[j]))
                    return true;
            }
        }
        return false;
    }
}

