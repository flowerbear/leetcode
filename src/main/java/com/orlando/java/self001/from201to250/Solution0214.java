package com.orlando.java.self001.from201to250;

/*
 * Shortest Palindrome
 *
 * You are given a string s. You can convert s to a palindrome by adding characters in front of it.
 *
 * Return the shortest palindrome you can find by performing this transformation.
 *
 */
public class Solution0214 {

  // KMP
  public String shortestPalindrome(String s) {
    String temp = s + "#" + new StringBuilder(s).reverse().toString();
    int[] table = getTable(temp);

    return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
  }

  private int[] getTable(String s) {
    int[] table = new int[s.length()];
    for (int i = 1, len = 0; i < s.length();) {
      if (s.charAt(i) == s.charAt(len)) {
        table[i++] = ++len;
      } else if (len != 0) {
        len = table[len - 1];
      } else {
        table[i++] = len;
      }
    }
    return table;
  }
}
