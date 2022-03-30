package com.orlando.java.self001.from251to300;

/*
 * Add Digits
 *
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 */
public class Solution0258 {
  public int addDigits(int num) {
    return num == 0 ? 0 : 1 + (num - 1) % 9;
  }

}
