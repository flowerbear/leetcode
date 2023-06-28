package com.orlando.java.self001.from701to750;

public class Solution0724 {

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int n : nums) totalSum += n;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 == totalSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}

