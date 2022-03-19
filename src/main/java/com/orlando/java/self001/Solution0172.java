package com.orlando.java.self001;

/*
 * Factorial Trailing Zeroes
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 *
 */
public class Solution0172 {

  public int trailingZeroes(int n) {
    int result = 0;
    while (n > 0) {
      n = n / 5;
      result += n;
    }
    return result;
  }
}
