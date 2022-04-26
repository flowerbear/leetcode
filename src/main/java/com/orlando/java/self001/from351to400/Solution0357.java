package com.orlando.java.self001.from351to400;

/*
 * Count Numbers with Unique Digits
 *
 * Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
 *
 */
public class Solution0357 {

  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) return 1;
    int result = 10, uniqueDigits = 9, availableNumber = 9;
    while (n > 1 && availableNumber > 0) {
      n--;
      uniqueDigits = uniqueDigits * availableNumber;
      result += uniqueDigits;
      availableNumber--;
    }
    return result;
  }
}

