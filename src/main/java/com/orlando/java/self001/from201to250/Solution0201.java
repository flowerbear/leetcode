package com.orlando.java.self001.from201to250;

/*
 * Bitwise AND of Numbers Range
 *
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers
 * in this range, inclusive.
 *
 */
public class Solution0201 {

  public int rangeBitwiseAnd(int left, int right) {
    if (left == 0) return 0;

    int moveFactor = 1;
    while (left != right) {
      left >>= 1;
      right >>= 1;
      moveFactor <<= 1;
    }
    return left * moveFactor;
  }
}
