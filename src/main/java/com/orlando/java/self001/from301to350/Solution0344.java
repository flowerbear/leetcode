package com.orlando.java.self001.from301to350;

/*
 * Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 */
public class Solution0344 {

  public void reverseString(char[] s) {
    int i = 0, j = s.length - 1;
    while (i <= j) {
      char temp = s[i];
      s[i++] = s[j];
      s[j--] = temp;
    }
  }
}

