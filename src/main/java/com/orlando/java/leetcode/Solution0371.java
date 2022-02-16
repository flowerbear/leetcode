package com.orlando.java.leetcode;

/*
 * Sum of Two Integers
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */
public class Solution0371 {

  public int getSum(int a, int b) {
    int c;
    while (b != 0) {
      c = (a & b);
      a = a ^ b;
      b = (c) << 1;
    }

    return a;
  }
}
