package com.orlando.java.self001.from351to400;

import java.util.Stack;

/*
 * Decode String
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are
 * well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 */
public class Solution0394 {

  public String decodeString(String s) {
    Stack<String> stackString = new Stack<>();
    Stack<Integer> stackNumber = new Stack<>();
    int curNum = 0;
    StringBuilder curString = new StringBuilder("");
    for (char c : s.toCharArray()) {
      if (c == '[') {
        stackString.push(curString.toString());
        stackNumber.push(curNum);
        curString.setLength(0);
        curNum = 0;
      } else if (c == ']') {
        int num = stackNumber.pop();
        String str = stackString.pop();
        String curStr = curString.toString();
        curString.setLength(0);
        curString.append(str).append(curStr.repeat(num));
      } else if (Character.isDigit(c)) {
        curNum = curNum * 10 + (c - '0');
      } else {
        curString.append(c);
      }
    }
    return curString.toString();
  }
}

