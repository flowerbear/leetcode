package com.orlando.java.self001;

/*
 * Plus One
 *
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of
 * the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 */
public class Solution0066 {

  public int[] plusOne(int[] digits) {
    int n = digits.length;

    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    int[] newNum = new int[n+1];
    newNum[0] = 1;
    return newNum;
  }
}
