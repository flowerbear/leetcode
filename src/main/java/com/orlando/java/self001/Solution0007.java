package com.orlando.java.self001;

/*
 * Reverse Integer
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
 * the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 */
public class Solution0007 {

  // Check result before move on
  public int reverse(int x) {
    int result = 0;
    while (x != 0) {
      if (Math.abs(result) > Integer.MAX_VALUE / 10) return 0;
      result = result * 10 + x % 10;
      x /= 10;
    }
    return result;
  }
}
