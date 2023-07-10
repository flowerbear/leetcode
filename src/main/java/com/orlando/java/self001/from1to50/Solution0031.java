package com.orlando.java.self001.from1to50;

import java.util.Arrays;

/*
 * Next Permutation
 *
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 *
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
 * More formally, if all the permutations of the array are sorted in one container according to their
 * lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted
 * container. If such arrangement is not possible, the array must be rearranged as the lowest possible order
 * (i.e., sorted in ascending order).
 *
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 *
 */
public class Solution0031 {

  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 0) return;
    int len = nums.length, i = len - 2;
    // Find the first decreasing element from end
    while (i >= 0 && nums[i + 1] <= nums[i]) i--;

    if (i >= 0) {
      int j = len - 1;
      // Find the number just big then nums[i]
      while (nums[j] <= nums[i]) j--;
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++; j--;
    }
  }

  public static void main(String[] args) {
    Solution0031 temp = new Solution0031();
    int[] test = new int[]{6, 5, 1, 2, 4, 3};
    temp.nextPermutation(test);
    System.out.println(Arrays.toString(test));
  }
}
