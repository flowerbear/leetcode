package com.orlando.java.self001.from1351to1400;

public class Solution1365 {


    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int count[] = new int[101], res[] = new int[n];
        for (int num : nums) count[num]++;
        for (int i = 1; i <= 100; i++) count[i] += count[i - 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) res[i] = 0;
            else res[i] = count[nums[i] - 1];
        }
        return res;
    }
}
