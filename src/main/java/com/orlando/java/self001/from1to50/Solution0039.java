package com.orlando.java.self001.from1to50;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Combination Sum
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique
 * combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the
 * given input.
 *
 */
public class Solution0039 {

  // Backtrack
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(result, new ArrayList<>(), candidates, target, 0);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
    if (remain < 0) return;
    else if (remain == 0) result.add(new ArrayList<>(tempList));
    else {
      for (int i = start; i < nums.length; i++) {
        tempList.add(nums[i]);
        backtrack(result, tempList, nums, remain - nums[i], i);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
