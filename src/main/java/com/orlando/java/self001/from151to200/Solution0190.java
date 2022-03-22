package com.orlando.java.self001.from151to200;

/*
 * Reverse Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 */
public class Solution0190 {

  public int reverseBits(int n) {
    if (n == 0) return 0;

    int result = 0;
    for (int i = 0; i < 32; i++) {
      result <<= 1;
      if ((n & 1) == 1) result++;
      n >>= 1;
    }
    return result;
  }
}
