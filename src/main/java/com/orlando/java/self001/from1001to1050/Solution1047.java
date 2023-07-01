package com.orlando.java.self001.from1001to1050;

public class Solution1047 {

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) sb.deleteCharAt(size - 1);
            else sb.append(c);
        }

        return sb.toString();
    }

    public String removeDuplicates1(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; j++, i++) {
            res[i] = res[j];
            if (i > 0 && res[i] == res[i - 1]) i -= 2;
        }
        return new String(res, 0, i);
    }
}
