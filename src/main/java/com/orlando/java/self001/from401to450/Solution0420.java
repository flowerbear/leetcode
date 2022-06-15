package com.orlando.java.self001.from401to450;

/*
 * Strong Password Checker
 *
 * A password is considered strong if the below conditions are all met:
 *
 *   > It has at least 6 characters and at most 20 characters.
 *   > It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
 *   > It does not contain three repeating characters in a row (i.e., "...aaa..." is weak, but "...aa...a..." is
 *     strong, assuming other conditions are met).
 *
 * Given a string password, return the minimum number of steps required to make password strong. if password is already strong, return 0.
 *
 * In one step, you can:
 *
 *   > Insert one character to password,
 *   > Delete one character from password, or
 *   > Replace one character of password with another character.
 *
 */
public class Solution0420 {

  public int strongPasswordChecker(String password) {
    int oneSeq = 0, twoSeq = 0, i = 2, missing = 3, n = password.length();
    for (char c : password.toCharArray()) {
      if (Character.isUpperCase(c)) {
        missing--; break;
      }
    }
    for (char c : password.toCharArray()) {
      if (Character.isLowerCase(c)) {
        missing--; break;
      }
    }
    for (char c : password.toCharArray()) {
      if (Character.isDigit(c)) {
        missing--; break;
      }
    }
    int changes = 0;
    while (i < n) {
      if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i - 2)) {
        int len = 2;
        while (i < n && password.charAt(i) == password.charAt(i - 1)) {
          len++; i++;
        }
        changes += len / 3;
        if (len % 3 == 0) oneSeq++;
        else if (len % 3 == 1) twoSeq++;
      } else {
        i++;
      }
    }
    if (n < 6) return Math.max(6 - n, missing);
    if (n <= 20) return Math.max(changes, missing);
    int deletes = n - 20;
    changes -= Math.min(oneSeq, deletes);
    changes -= Math.min(Math.max(deletes - oneSeq, 0), twoSeq * 2) / 2;
    changes -= Math.max(deletes - oneSeq - twoSeq * 2, 0) / 3;
    return deletes + Math.max(changes, missing);
  }
}

