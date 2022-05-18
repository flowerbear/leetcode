package com.orlando.java.self001.from351to400;

/*
 * Nth Digit
 *
 * Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
 *
 */
public class Solution0400 {

  // 1 ~ 9 include 9 one digit number;
  // 10 ~ 99 include 90 two digits number;
  // 100 ~ 999 include 900 three digits number;
  // 1000 ~ 9999 include 9000 four digits number;
  // ...
  // len is how many digits:1 or 2 or 3 ..., range is 9 or 90 or 900 ...
  public int findNthDigit(int n) {
    int len = 1, i = 1;
    long range = 9;
    while (n > len * range) {
      n -= len * range;
      len++;
      range *= 10;
      i *= 10;
    }
    i += (n - 1) / len;
    String s = Integer.toString(i);
    return Character.getNumericValue(s.charAt((n - 1) % len));
  }
}

