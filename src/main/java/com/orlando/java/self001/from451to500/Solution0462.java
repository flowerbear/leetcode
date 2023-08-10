package com.orlando.java.self001.from451to500;

import java.util.Arrays;

public class Solution0462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, count = 0;
        while (i < j) {
            count += nums[j--] - nums[i++];

        }
        return count;
    }
}

