package com.orlando.java.self001.from351to400;

/*
 * Super Pow
 *
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer
 * given in the form of an array.
 *
 */
public class Solution0372 {

  // https://leetcode.com/problems/super-pow/discuss/84466/Math-solusion-based-on-Euler's-theorem-power-called-only-ONCE-C%2B%2BJava1-line-Python
  public int superPow(int a, int[] b) {
    if (a % 1337 == 0) {
      return 0;
    }

    int p = 0;
    for (int i : b) {
      p = (p * 10 + i) % 1140;
    }
    if (p == 0) p += 1140;
    return power(a, p, 1337);
  }

  private int power(int a, int n, int mod) {
    a %= mod;
    int result = 1;
    while (n != 0) {
      if ((n & 1) != 0) {
        result = result * a % mod;
      }
      a = a * a % mod;
      n >>= 1;
    }
    return result;
  }
}

