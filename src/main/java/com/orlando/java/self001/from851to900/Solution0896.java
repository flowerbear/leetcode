package com.orlando.java.self001.from851to900;

public class Solution0896 {

    public boolean isMonotonic(int[] nums) {
        boolean inc = true, dec = true;
        for (int i = 1; i < nums.length; i++) {
            inc &= nums[i - 1] <= nums[i];
            dec &= nums[i - 1] >= nums[i];
        }
        return inc || dec;
    }
}

