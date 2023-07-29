package com.orlando.java.self001.from401to450;

public class Solution0443 {

    public int compress(char[] chars) {
        int res = 0, i = 0;
        while (i < chars.length) {
            final char letter = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == letter) {
                count++;
                i++;
            }
            chars[res++] = letter;
            if (count > 1) {
                for (final char c : String.valueOf(count).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }
        return res;
    }
}

