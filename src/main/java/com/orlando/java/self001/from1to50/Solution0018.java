package com.orlando.java.self001.from1to50;

import java.util.*;

/*
 * 4Sum
 *
 * Given an array nums of n integers, return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * You may return the answer in any order.
 *
 */
public class Solution0018 {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, target, 0, 4);
  }

  private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
    List<List<Integer>> result = new ArrayList<>();

    if (start == nums.length) {
      return result;
    }

    int averageValue = target / k;

    if (nums[start] > averageValue || averageValue > nums[nums.length - 1]) {
      return result;
    }

    if (k == 2) {
      return twoSum(nums, target, start);
    }

    for (int i = start; i < nums.length; i++) {
      if (i == start || nums[i - 1] != nums[i]) {
        for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
          result.add(new ArrayList<>(Arrays.asList(nums[i])));
          result.get(result.size() - 1).addAll(subset);
        }
      }
    }

    return result;
  }

  // Two Point
  private List<List<Integer>> twoSum(int[] nums, int target, int start) {
    List<List<Integer>> result = new ArrayList<>();
    int l = start, r = nums.length - 1;
    while (l < r) {
      int sum = nums[l] + nums[r];
      if (sum < target || (l > start && nums[l] == nums[l - 1])) l++;
      else if (sum > target || (r < nums.length - 1 && nums[r] == nums[r + 1])) r--;
      else result.add(Arrays.asList(nums[l++], nums[r--]));
    }
    return result;
  }

  // HashSet
  private List<List<Integer>> twoSumHashSet(int[] nums, int target, int start) {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> s = new HashSet<>();

    for (int i = start; i < nums.length; i++) {
      if (result.isEmpty() || result.get(result.size() - 1).get(1) != nums[i]) {
        if (s.contains(target - nums[i])) {
          result.add(Arrays.asList(target - nums[i], nums[i]));
        }
      }
      s.add(nums[i]);
    }

    return result;
  }
}
