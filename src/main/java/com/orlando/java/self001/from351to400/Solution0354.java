package com.orlando.java.self001.from351to400;

import java.util.Arrays;

/*
 * Russian Doll Envelopes
 *
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of
 * an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the
 * other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 *
 * Note: You cannot rotate an envelope.
 *
 */
public class Solution0354 {

  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0])));
    return longestIncreasingSubsequence(envelopes);
  }

  private int longestIncreasingSubsequence(int[][] envelopes) {
    if (envelopes == null || envelopes.length == 0) return 0;
    int[][] tails = new int[envelopes.length][2];
    int size = 0;
    for (int[] envelope : envelopes) {
      int l = 0, r = size;
      while (l < r) {
        int mid = l + (r - l) / 2;
        if (tails[mid][1] < envelope[1]) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }
      tails[l] = envelope;
      if (l == size) size++;
    }
    return size;
  }


}

