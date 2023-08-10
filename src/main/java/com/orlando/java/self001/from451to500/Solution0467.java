package com.orlando.java.self001.from451to500;

import java.util.Arrays;

public class Solution0467 {

    public int findSubstringInWraproundString(String s) {
        int n = s.length(), max = 1;
        int[] count = new int[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                int t = chars[i] - chars[i - 1];
                if (t == 1 || t == -25) {
                    max++;
                } else {
                    max = 1;
                }
            }

            int idx = chars[i] - 'a';
            count[idx] = Math.max(count[idx], max);
        }

        /*
        int res = 0;
        for (int c : count) {
            res += c;
        }*/
        return Arrays.stream(count).sum();
    }
}

