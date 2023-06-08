package com.orlando.java.self001.from1to50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Permutations
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in
 * any order.
 *
 */
public class Solution0046 {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), nums);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) result.add(new ArrayList<>(tempList));
    else {
      for (int i = 0; i < nums.length; i++) {
        if (tempList.contains(nums[i])) continue;
        tempList.add(nums[i]);
        backtrack(result, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    Solution0046 temp = new Solution0046();
    temp.permute(new int[]{1, 2, 3});
  }


  List<List<Integer>> res = new LinkedList<>();

  public List<List<Integer>> permute1(int[] nums) {
    boolean[] used = new boolean[nums.length];
    backtrack1(nums, new LinkedList<>(), used);
    return res;
  }

  private void backtrack1(int[] nums, LinkedList<Integer> track, boolean[] used) {
    if (track.size() == nums.length) {
      res.add(new LinkedList(track));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      track.add(nums[i]);
      used[i] = true;
      backtrack1(nums, track, used);
      track.removeLast();
      used[i] = false;
    }
  }
}
