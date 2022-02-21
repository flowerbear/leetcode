package com.orlando.java.self;

import java.util.Random;

/*
 * Random Pick with Weight
 *
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 *
 * You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1]
 * (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
 *
 * For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%),
 * and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 *
 */
public class Solution0528 {

  private Random random;
  private int[] cSums;

  public Solution0528(int[] w) {
    this.random = new Random();
    // {2,5,3,4}
    cSums[0] = w[0];
    for (int i = 1; i < w.length; i++) {
      cSums[i] = w[i] + cSums[i - 1];
    }
  }

  public int pickIndex() {
    int idx = random.nextInt(cSums[cSums.length - 1] + 1);
    int left = 0, right = cSums.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (idx == cSums[mid]) {
        return mid;
      } else if (idx < cSums[mid]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
