package com.orlando.java.self001.from351to400;

/*
 * Sum of Two Integers
 *
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 */
public class Solution0371 {

  // https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
  public int getSum(int a, int b) {
    int c;
    while (b != 0) {
      c = (a & b);
      a = a ^ b;
      b = (c) << 1;
    }

    return a;
  }

  public int getSum1(int a, int b) {
    if (b == 0) return a;
    int sum = a ^ b;
    int carry = (a & b) << 1;
    return getSum1(sum, carry);
  }
}

