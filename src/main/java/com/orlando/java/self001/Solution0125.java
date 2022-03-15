package com.orlando.java.self001;

/*
 * Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters
 * and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 */
public class Solution0125 {

  public boolean isPalindrome(String s) {
    if (s.isEmpty()) return true;

    int l = 0, r = s.length() - 1;
    char cL, cR;
    while (l <= r) {
      cL = s.charAt(l);
      cR = s.charAt(r);
      if (!Character.isLetterOrDigit(cL)) l++;
      else if (!Character.isLetterOrDigit(cR)) r--;
      else {
        if (Character.toLowerCase(cL) != Character.toLowerCase(cR)) return false;
        l++; r--;
      }
    }
    return true;
  }
}
