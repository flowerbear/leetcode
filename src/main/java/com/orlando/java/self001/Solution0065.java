package com.orlando.java.self001;

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
    boolean pointSeen = false, eSeen = false, numberSeen = false;

    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        numberSeen = true;
      } else if (s.charAt(i) == '.') {
        if (eSeen || pointSeen) return false;
        pointSeen = true;
      } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
        if (eSeen || !numberSeen) return false;
        eSeen = true;
        numberSeen = false;
      } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
        if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i) != 'E') return false;
      } else {
        return false;
      }
    }
    return numberSeen;
  }
}
