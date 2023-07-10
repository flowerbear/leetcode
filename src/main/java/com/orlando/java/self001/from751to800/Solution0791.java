package com.orlando.java.self001.from751to800;

public class Solution0791 {

    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a']-- > 0) sb.append(c);
        }
        for (char c = 'a'; c <= 'z'; c++)
            while (count[c - 'a']-- > 0) sb.append(c);
        return sb.toString();
    }
}

