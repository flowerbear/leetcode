package com.orlando.java.self001.from851to900;

import java.util.Stack;

public class Solution0856 {

    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(score);
                score = 0;
            } else {
                score = st.peek() +  (score > 0 ? score * 2 : 1);
                st.pop();
            }
        }
        return score;
    }
}

