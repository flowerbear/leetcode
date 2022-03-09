package com.orlando.java.self001;

/*
 * Add Binary
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 */
public class Solution0067 {

  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1, j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
      int sum = carry + (i >= 0 ? a.charAt(i--) - '0' : 0) + (j >= 0 ? b.charAt(j--) - '0' : 0);
      carry = sum > 1 ? 1 : 0;
      sb.append(sum % 2);
    }
    if (carry != 0) sb.append(carry);
    return sb.reverse().toString();
  }
}
