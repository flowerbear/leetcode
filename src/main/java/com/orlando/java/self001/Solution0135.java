package com.orlando.java.self001;

import java.util.Arrays;

/*
 * Candy
 *
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 *   Each child must have at least one candy.
 *   Children with a higher rating get more candies than their neighbors.
 *
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 */
public class Solution0135 {

  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] res = new int[n];
    Arrays.fill(res, 1);
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        res[i] = res[i - 1] + 1;
      }
    }
    for (int i = n - 1; i > 0; i--) {
      if (ratings[i - 1] > ratings[i]) {
        res[i - 1] = Math.max(res[i] + 1, res[i - 1]);
      }
    }

    int sum = 0;
    for (int r : res) sum += r;
    return sum;
  }
}
