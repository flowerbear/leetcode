package com.orlando.java.self001.from601to650;

import java.util.List;
import java.util.Stack;

public class Solution0636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> st = new Stack<>();
        int[] res = new int[n];

        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                st.push(log);
            } else {
                Log top = st.pop();
                res[top.id] += (log.time - top.time + 1);
                if (!st.isEmpty()) {
                    res[st.peek().id] -= (log.time - top.time + 1);
                }
            }
        }
        return res;
    }

    class Log {
        int id;
        boolean isStart;
        int time;

        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }
}

