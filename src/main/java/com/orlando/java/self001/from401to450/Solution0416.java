package com.orlando.java.self001.from401to450;

/*
 * Partition Equal Subset Sum
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two
 * subsets such that the sum of elements in both subsets is equal.
 *
 */
public class Solution0416 {

  public boolean canPartition(int[] nums) {
    int sum = 0, n = nums.length;
    for (int num : nums) sum += num;
    if ((sum & 1) == 1) return false;

    sum /= 2;
    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;

    for (int num : nums) {
      for (int i = sum; i > 0; i--) {
        if (i >= num) {
          dp[i] = dp[i] || dp[i - num];
        }
      }
    }

    return dp[sum];
  }
}

