package com.orlando.java.self001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Subsets
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Solution0078 {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(result, new ArrayList<>(), nums, 0);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
    result.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      backtrack(result, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}
