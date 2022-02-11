package com.orlando.java.leetcode;

/*
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 */
public class Solution0258 {

  public int addDigits(int num) {
    int result = 0;
    while (num > 0) {
      result += num % 10;
      num = num / 10;
      if (num == 0 && result > 9) {
        num = result;
        result = 0;
      }
    }
    return result;
  }

  public int addDigits1(int num) {
    if (num == 0) return 0;
    if (num % 9 == 0) return 9;
    return num % 9;
  }

  public int addDigits2(int num) {
    return num == 0 ? 0 : 1 + (num - 1) % 9;
  }
}
