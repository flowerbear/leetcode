package com.orlando.java.self001;

/*
 * Multiply Strings
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also
 * represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Solution0043 {

  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) return "0";

    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];

    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int p1 = i + j, p2 = i + j + 1;
        int sum = value + pos[p2];

        pos[p1] += sum / 10;
        pos[p2] = sum % 10;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
