package com.orlando.java.self001.from301to350;

import org.eclipse.persistence.internal.indirection.EISOneToManyQueryBasedValueHolder;

import java.math.BigInteger;

/*
 * Additive Number
 *
 * An additive number is a string whose digits can form an additive sequence.
 *
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent
 * number in the sequence must be the sum of the preceding two.
 *
 * Given a string containing only digits, return true if it is an additive number or false otherwise.
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 *
 */
public class Solution0306 {

  public boolean isAdditiveNumber(String num) {
    int n = num.length();
    for (int i = 1; i <= n / 2; i++) {
      if (num.charAt(0) == '0' && i > 1) return false;
      BigInteger x1 = new BigInteger(num.substring(0, i));
      for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
        if (num.charAt(i) == '0' && j > 1) break;
        BigInteger x2 = new BigInteger(num.substring(i, i + j));
        if (isValid(x1, x2, j + i, num)) return true;
      }
    }
    return false;
  }

  private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
    if (start == num.length()) return true;
    x2 = x2.add(x1);
    x1 = x2.subtract(x1);
    String sum = x2.toString();
    return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
  }


  public boolean isAdditiveNumber1(String num) {
    int n = num.length();
    for (int i = 1; i <= n / 2; i++)
      for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
        if (isValid(i, j, num)) return true;
      }
    return false;
  }

  private boolean isValid(int i, int j, String num) {
    if (num.charAt(0) == '0' && i > 1) return false;
    if (num.charAt(i) == '0' && j > 1) return false;
    String sum;
    Long x1 = Long.parseLong(num.substring(0, i)), x2 = Long.parseLong(num.substring(i, i + j));
    for (int start = i + j; start != num.length(); start += sum.length()) {
      x2 = x2 + x1;
      x1 = x2 - x1;
      sum = x2.toString();
      if (!num.startsWith(sum, start)) return false;
    }
    return true;
  }
}
