package com.orlando.java.self001.from451to500;

import java.util.Stack;

public class Solution0484 {

    public int[] findPermutation(String s) {
        int n = s.length(), res[] = new int[n + 1], idx = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i + 1);
            if (s.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    res[idx++] = stack.pop();
                }
            }
        }
        stack.push(n + 1);
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }
}

