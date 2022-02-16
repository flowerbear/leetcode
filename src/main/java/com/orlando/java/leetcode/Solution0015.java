package com.orlando.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 3Sum
 *
 */
public class Solution0015 {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) break;

      int l = i + 1, r = n - 1;

      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum < 0) l++;
        else if (sum > 0) r--;
        else {
          result.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l + 1 <= r && nums[l] == nums[l + 1]) l++;
          l++;
          r--;
        }
      }

      while (i + 1 < n && nums[i + 1] == nums[i]) i++;
    }
    return result;
  }
}
