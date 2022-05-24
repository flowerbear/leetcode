package com.orlando.java.self001.from401to450;

/*
 * Convert a Number to Hexadecimal
 *
 * Given an integer num, return a string representing its hexadecimal representation. For negative integers,
 * two’s complement method is used.
 *
 * All the letters in the answer string should be lowercase characters, and there should not be any leading zeros
 * in the answer except for the zero itself.
 *
 * Note: You are not allowed to use any built-in library method to directly solve this problem.
 *
 */
public class Solution0405 {

  public String toHex(int num) {
    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    if (num == 0) return "0";
    StringBuilder result = new StringBuilder();
    while (num != 0) {
      result.insert(0, map[(num & 15)]);
      num = (num >>> 4);
    }
    return result.toString();
  }
}

