package com.orlando.java.self001.from301to350;

/*
 * Power of Three
 *
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 */
public class Solution0326 {

  public boolean isPowerOfThree(int n) {
    return n > 0 && (1162261467 % n == 0);
  }

  public boolean isPowerOfThree1(int n) {
    if (n > 1)
      while (n % 3 == 0) n /= 3;
    return n == 1;
  }
}

