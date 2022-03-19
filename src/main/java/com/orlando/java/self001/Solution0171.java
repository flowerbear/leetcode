package com.orlando.java.self001;

/*
 * Excel Sheet Column Number
 *
 * Given a string columnTitle that represents the column title as appear in an Excel sheet,
 * return its corresponding column number.
 *
 */
public class Solution0171 {

  public int titleToNumber(String columnTitle) {
    int power = 1, result = 0;
    for (int i = columnTitle.length() - 1; i >= 0; i--, power *= 26) {
      result += (columnTitle.charAt(i) - 'A' + 1) * power;
    }
    return result;
  }
}
