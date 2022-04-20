package com.orlando.java.self001.from301to350;

/*
 * Create Maximum Number
 *
 * You are given two integer arrays nums1 and nums2 of lengths m and n respectively. nums1 and nums2 represent the
 * digits of two numbers. You are also given an integer k.
 *
 * Create the maximum number of length k <= m + n from digits of the two numbers. The relative order of the digits
 * from the same array must be preserved.
 *
 * Return an array of the k digits representing the answer.
 *
 */
public class Solution0321 {

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int n = nums1.length, m = nums2.length;
    int[] result = new int[k];
    for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
      int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
      if (greater(candidate, 0, result, 0)) result = candidate;
    }
    return result;
  }

  private boolean greater(int[] num1, int i, int[] num2, int j) {
    while (i < num1.length && j < num2.length && num1[i] == num2[j]) {
      i++; j++;
    }
    return j == num2.length || (i < num1.length && num1[i] > num2[j]);
  }

  private int[] merge(int[] num1, int[] num2, int k) {

    int[] result = new int[k];
    for (int i = 0, j = 0, r = 0; r < k; r++) {
      result[r] = greater(num1, i, num2, j) ? num1[i++] : num2[j++];
    }
    return result;
  }

  private int[] maxArray(int[] nums1, int k) {

    int n = nums1.length;
    int[] result = new int[k];
    for (int i = 0, j = 0; i < n; i++) {
      while (n - i + j > k && j > 0 && result[j - 1] < nums1[i]) j--;
      if (j < k) result[j++] = nums1[i];
    }
    return result;
  }


}

