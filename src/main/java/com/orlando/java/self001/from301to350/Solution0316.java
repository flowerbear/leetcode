package com.orlando.java.self001.from301to350;

import java.util.Stack;

/*
 * Remove Duplicate Letters
 *
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible results.
 *
 */
public class Solution0316 {

  public String removeDuplicateLetters(String s) {
    int[] lastIndex = new int[26];
    for (int i = 0; i < s.length(); i++) {
      lastIndex[s.charAt(i) - 'a'] = i;
    }

    boolean[] seen = new boolean[26];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      int cur = s.charAt(i) - 'a';
      if (seen[cur]) continue;
      while (!stack.isEmpty() && stack.peek() > cur && i < lastIndex[stack.peek()]) {
        seen[stack.pop()] = false;
      }
      stack.push(cur);
      seen[cur] = true;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append((char) (stack.pop() + 'a'));
    }
    return sb.reverse().toString();
  }
}

