package com.orlando.java.leetcode;

/*
 * Counting Bits
 *
 */
public class Solution0338 {


  public int[] countBits(int n) {
    int[] result = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      result[i] = result[i >> 1] + (i & 1);
    }
    return result;
  }
}
