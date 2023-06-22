package com.orlando.java.self001.from451to500;

import java.util.HashMap;

public class Solution0494 {

    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        backtrack(nums, 0, target);
        return result;
    }

    private void backtrack(int[] nums, int i, int remain) {

        if (i == nums.length) {
            if (remain == 0) result++;
            return;
        }

        remain += nums[i];
        backtrack(nums, i + 1, remain);
        remain -= nums[i];
        remain -= nums[i];
        backtrack(nums, i + 1, remain);
        remain += nums[i];
    }

    HashMap<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays1(int[] nums, int target) {
        int n = nums.length;
        return dp(nums, 0, target);
    }

    private int dp(int[] nums, int i, int remain) {
        if (i == nums.length) {
            if (remain == 0) return 1;
            return 0;
        }

        String key = i + "," + remain;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result = dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);
        memo.put(key, result);
        return result;
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum < Math.abs(target) || (sum + target) % 2 == 1)
            return 0;
        return subsets1(nums, (sum + target) / 2);
    }

    private int subsets(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    private int subsets1(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i - 1])
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }

}

