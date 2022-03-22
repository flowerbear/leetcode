package com.orlando.java.self001.from1to50;

/*
 * Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 */
public class Solution0050 {

  public double myPow(double x, int n) {
    if (n == 0) return 1;
    if (n < 0) {
      return 1 / x * myPow(1 / x, -(n + 1));
    }
    return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
  }
}
