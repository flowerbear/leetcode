package com.orlando.java.self001.from1201to1250;

import java.util.Stack;

public class Solution1249 {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') st.push(i);
            else if (ch[i] == ')') {
                if (st.isEmpty()) ch[i] = '#';
                else st.pop();
            }
        }
        while (!st.isEmpty()) {
            ch[st.pop()] = '#';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '#') sb.append(ch[i]);
        }

        return sb.toString();
    }


    public String minRemoveToMakeValid1(String s) {
        int count = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') count++;
            else if (ch[i] == ')') {
                if (count == 0) ch[i] = '#';
                else count--;
            }
        }

        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == '(' && count > 0) {
                ch[i] = '#';
                count--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '#') sb.append(ch[i]);
        }

        return sb.toString();
    }
}
