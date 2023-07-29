package com.orlando.java.self001.from401to450;

import java.util.Stack;

public class Solution0439 {

    public String parseTernary(String expression) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : expression.toCharArray()) stack1.push(c);
        while (stack1.size() > 1) {
            char c1 = stack1.pop(), c2 = stack1.pop();
            if (c2 == ':') {
                stack2.push(c1);
            } else {
                char conditionChar = stack1.pop();
                boolean condition = conditionChar == 'T';
                char nextChar = condition ? c1 : stack2.pop();
                stack1.push(nextChar);
            }
        }
        return String.valueOf(stack1.pop());
    }
}

