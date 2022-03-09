package com.orlando.java.self001;

/*
 * Sqrt(x)
 *
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the
 * result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 */
public class Solution0069 {

  public int mySqrt(int x) {
    if (x == 0) return 0;
    int left = 1, right = Integer.MAX_VALUE;
    while (true) {
      int mid = left + (right - left) / 2;
      if (mid > x / mid) right = mid - 1;
      else {
        if (mid + 1 > x / (mid + 1)) return mid;
        left = mid + 1;
      }
    }
  }
}
