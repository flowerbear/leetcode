package com.orlando.java.self001.from2451to2500;

public class Solution2448 {


    public long minCost(int[] nums, int[] cost) {
        long left = nums[0], right = nums[0];
        for (int n : nums) {
            left = Math.min(left, n);
            right = Math.max(right, n);
        }
        long res = 0L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long r1 = findCost(nums, cost, mid);
            long r2 = findCost(nums, cost, mid + 1);
            res = Math.min(r1, r2);
            if (r1 < r2) right = mid;
            else left = mid + 1;
        }
        return res;
    }

    private long findCost(int[] nums, int[] cost, long target) {
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - target) * cost[i];
        }
        return res;
    }
}
