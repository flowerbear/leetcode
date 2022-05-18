package com.orlando.java.self001.from351to400;

import java.util.*;

/*
 * Random Pick Index
 *
 * Given an integer array nums with possible duplicates, randomly output the index of a given target number. You can
 * assume that the given target number must exist in the array.
 *
 * Implement the Solution class:
 *
 *   > Solution(int[] nums) Initializes the object with the array nums.
 *   > int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's,
 * then each index should have an equal probability of returning.
 *
 */
public class Solution0398 {

  public class Solution {

    int[] nums;
    Random rnd;

    public Solution(int[] nums) {
      this.nums = nums;
      this.rnd = new Random();
    }

    public int pick(int target) {
      int result = -1, count = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != target) continue;
        if (rnd.nextInt(++count) == 0) result = i;
      }
      return result;
    }
  }

  public class Solution1 {

    private Random rnd = new Random();
    private Map<Integer, List<Integer>> map;

    public Solution1(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
          if (!map.containsKey(nums[i])) {
            map.put(nums[i], new ArrayList<>());
          }
          map.get(nums[i]).add(i);
        }
    }
    public int pick(int target) {
      int result = -1;
      int l = map.get(target).size();
      result = map.get(target).get(rnd.nextInt(l));
      return result;
    }
  }

}

