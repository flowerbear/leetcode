package com.orlando.java.self001.from51to100;

/*
 * Valid Number
 *
 * A valid number can be split up into these components (in order):
 *   A decimal number or an integer.
 *   (Optional) An 'e' or 'E', followed by an integer.
 *
 * A decimal number can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 *   One or more digits, followed by a dot '.'.
 *   One or more digits, followed by a dot '.', followed by one or more digits.
 *   A dot '.', followed by one or more digits.
 *
 * An integer can be split up into these components (in order):
 *   (Optional) A sign character (either '+' or '-').
 *   One or more digits.
 *
 * Given a string s, return true if s is a valid number.
 *
 */
public class Solution0065 {

  public boolean isNumber(String s) {
    s = s.trim();
    boolean pointSeen = false, eSeen = false, numSeen = false;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        numSeen = true;
      } else if (c == '.') {
        if (eSeen || pointSeen) return false;
        else pointSeen = true;
      } else if (c == 'e' || c == 'E') {
        if (eSeen || !numSeen) return false;
        else {
          eSeen = true;
          numSeen = false;
        }
      } else if (c == '-' || c == '+') {
        if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
      } else {
        return false;
      }
    }
    return numSeen;
  }
}
