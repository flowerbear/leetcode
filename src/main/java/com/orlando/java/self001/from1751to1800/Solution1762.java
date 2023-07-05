package com.orlando.java.self001.from1751to1800;

import java.util.Stack;

public class Solution1762 {

    public int[] findBuildings(int[] heights) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while ((!st.isEmpty() && heights[i] >= heights[st.peek()])) {
                st.pop();
            }
            st.push(i);
        }
        int size = st.size();
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[size - 1 - i] = st.pop();
        }
        return res;
    }
}
