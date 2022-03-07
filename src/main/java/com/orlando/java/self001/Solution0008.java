package com.orlando.java.self001;

/*
 * String to Integer (atoi)
 *
 * mplement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
 * (similar to C/C++'s atoi function).
 *
 */
public class Solution0008 {

  // check leading space; check sign; check isDigit;
  // check overflow before add to result
  public int myAtoi(String s) {
    int sign = 1, result = 0, n = s.length(), i = 0;

    // Discard all space from the beginning
    while (i < n && s.charAt(i) == ' ') {
      i++;
    }

    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
      sign = s.charAt(i++) == '+' ? 1 : -1;
    }

    while (i < n && Character.isDigit(s.charAt(i))) {
      int digit = s.charAt(i) - '0';

      if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      result = 10 * result + digit;
      i++;
    }
    return sign * result;
  }
}
