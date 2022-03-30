package com.orlando.java.self001.from201to250;

/*
 * Strobogrammatic Number
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 */
public class Solution0246 {

  public boolean isStrobogrammatic(String num) {
    if (num.length() == 1)
      return num.equals("0") || num.equals("1") || num.equals("8");

    int l = 0, r = num.length();
    while (l <= r) {
      if (num.charAt(l) == num.charAt(r)) {
        if (num.charAt(l) != '1' && num.charAt(l) != '0' && num.charAt(l) != '8') return false;
      } else {
        if ((num.charAt(l) != '6' || num.charAt(r) != '9') && (num.charAt(l) != '9' || num.charAt(r) != '6')) return false;
      }
      l++; r--;
    }

    return true;
  }
}
