package com.orlando.java.self001.from51to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Subsets II
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 */
public class Solution0090 {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    bakctrack(result, new ArrayList<>(), nums, 0);
    return result;
  }

  private void bakctrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
    result.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      tempList.add(nums[i]);
      bakctrack(result, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}
