package com.orlando.java.self001.from351to400;

import java.util.Random;

/*
 * Shuffle an Array
 *
 * Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array
 * should be equally likely as a result of the shuffling.
 *
 * Implement the Solution class:
 *
 *   > Solution(int[] nums) Initializes the object with the integer array nums.
 *   > int[] reset() Resets the array to its original configuration and returns it.
 *   > int[] shuffle() Returns a random shuffling of the array.
 *
 */
public class Solution0384 {

  public class Solution {


    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
      this.nums = nums;
      rand = new Random();
    }

    public int[] reset() {
      return this.nums;
    }

    public int[] shuffle() {
      if (nums == null) return null;
      int[] a = nums.clone();
      for (int i = 1; i < a.length; i++) {
        int j = rand.nextInt(i + 1);
          swap(a, i, j);
      }
      return a;
    }

    private void swap(int[] a, int i, int j) {
      int t = a[i];
      a[i] = a[j];
      a[j] = t;
    }
  }
}

