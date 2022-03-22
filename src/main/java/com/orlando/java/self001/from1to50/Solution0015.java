package com.orlando.java.self001.from1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 3Sum
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 */
public class Solution0015 {

  // Sort array; nums[i] > 0 break; move two points l and r;
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
          l++; r--;
        }
      }

      while (i + 1 < n && nums[i] == nums[i + 1]) i++;
    }
    return result;
  }
}
