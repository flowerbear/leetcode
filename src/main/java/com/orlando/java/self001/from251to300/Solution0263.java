package com.orlando.java.self001.from251to300;

/*
 * Ugly Number
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return true if n is an ugly number.
 *
 */
public class Solution0263 {

  public boolean isUgly(int n) {
    for (int i = 2; i < 6 && n > 0; i++) {
      while (n % i == 0)
        n /= i;
    }
    return n == 1;
  }
}
