package com.orlando.java.leetcode;

/*
 * Number of 1 Bits
 *
 */
public class Solution0191 {

  public int hammingWeight(int n) {
    int result = 0;
    while (n != 0) {
      result += (n & 1);
      n = n >>> 1;
    }
    return result;
  }
}
