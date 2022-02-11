package com.orlando.java.leetcode;

import java.util.Random;

/*
 * Random Pick with Weight
 *
 */
public class Solution0528 {

  Random random;
  int[] wSums;

  public Solution0528(int[] w) {
    this.random = new Random();
    for (int i = 1; i < w.length; i++) {
      w[i] += w[i - 1];
    }
    this.wSums = w;
  }

  public int pickIndex() {
    int len = wSums.length;
    int idx = random.nextInt(wSums[len - 1]) + 1;
    int left = 0, right = len - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (wSums[mid] == idx) {
        return mid;
      } else if (wSums[mid] < idx) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
