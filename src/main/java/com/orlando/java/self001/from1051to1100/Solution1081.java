package com.orlando.java.self001.from1051to1100;

import java.util.Stack;

/*
 *
 * Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters
 * of s exactly once.
 *
 */
public class Solution1081 {

    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int[] counter = new int[256];
        for (Character c : s.toCharArray()) {
            counter[c]++;
        }
        boolean[] inStack = new boolean[256];
        for (Character c : s.toCharArray()) {
            counter[c]--;
            if (inStack[c]) continue;
            while (!stack.isEmpty() && stack.peek() > c) {
                if (counter[stack.peek()] == 0) break;
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
