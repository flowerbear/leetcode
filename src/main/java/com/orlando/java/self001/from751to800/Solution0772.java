package com.orlando.java.self001.from751to800;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution0772 {

    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue. add(c);
        return helper(queue);
    }

    private int helper(Queue<Character> s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        while (!s.isEmpty()) {
            char c = s.poll();
            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            if (c == '(') num = helper(s);

            if ((!Character.isDigit(c) && c != ' ') || s.isEmpty()) {
                switch (c) {
                    case '+':
                        stack.push(num); break;
                    case '-':
                        stack.push(-num); break;
                    case '*':
                        stack.push(stack.pop() * num); break;
                    case '/':
                        stack.push(stack.pop() / num); break;
                }

                sign = c;
                num = 0;
            }

            if (c == ')') break;

        }
        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }
}

