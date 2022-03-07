package com.orlando.java.self001;

/*
 * Divide Two Integers
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division,
 * and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 */
public class Solution0029 {

  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) return (1 << 31) - 1;
    int a = Math.abs(dividend), b = Math.abs(divisor), result = 0;
    while (a - b >= 0) {
      int tmp = b, count = 1;
      while (a - (tmp << 1) >= 0) {
        tmp <<= 1;
        count <<= 1;
      }
      a -= tmp;
      result += count;
    }
    return (dividend > 0) == (divisor > 0) ? result : -result;
  }

  public int divide1(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) return (1 << 31) - 1;
    int a = Math.abs(dividend), b = Math.abs(divisor), result = 0;
    for (int x = 31; x >=0; x--) {
      if ((a >>> x) - b >= 0) {
        result += 1 << x;
        a -= b << x;
      }
    }
    return (dividend > 0) == (divisor > 0) ? result : -result;
  }
}
