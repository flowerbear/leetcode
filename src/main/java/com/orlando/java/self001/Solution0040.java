package com.orlando.java.self001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 */
public class Solution0040 {

  // Backtrack
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        if(i > start && nums[i] == nums[i-1]) continue;
        tempList.add(nums[i]);
        backtrack(result, tempList, nums, remain - nums[i], i + 1);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
