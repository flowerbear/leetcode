package com.orlando.java.self001.from151to200;

/*
 * Excel Sheet Column Title
 *
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 *
 * For example:
 *   A -> 1
 *   B -> 2
 *   C -> 3
 *   ...
 *   Z -> 26
 *   AA -> 27
 *   AB -> 28
 *   ...
 *
 */
public class Solution0168 {

  public String convertToTitle(int columnNumber) {
    return columnNumber == 0 ? "" : convertToTitle((columnNumber - 1) / 26) + (char) ('A' + (columnNumber - 1) % 26);
  }

  public String convertToTitle1(int n) {
    StringBuilder result = new StringBuilder();
    while(n>0){
      n--;
      result.insert(0, (char)('A' + n % 26));
      n /= 26;
    }

    return result.toString();
  }
}
