package com.orlando.java.self001.from1051to1100;

public class Solution1060 {

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if (k >= nums[nums.length - 1]) return k + nums[0] + n - 1;

        int num = nums[0], index = 1;
        while (index < n && k > 0) {
            num++;
            if (num == nums[index]) index++;
            else k--;
        }
        return num + k;
    }
}
