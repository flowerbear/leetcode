package com.orlando.java.self001;

/*
 * Palindrome Number
 *
 * Given an integer x, return true if x is palindrome integer.
 *
 */
public class Solution0009 {

  // get a reversedNumber. Only need half digits.
  // return x == reservedNumber || x == reversedNumber / 10 (number length is odd number)
  public boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;
    int reversedNumber = 0;
    while (x > reversedNumber) {
      reversedNumber = 10 * reversedNumber + x % 10;
      x = x / 10;
    }
    return x == reversedNumber || x == reversedNumber / 10;
  }
}
