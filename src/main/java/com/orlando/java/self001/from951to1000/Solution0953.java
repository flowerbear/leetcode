package com.orlando.java.self001.from951to1000;

public class Solution0953 {

    int[] mapping = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            mapping[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i])) return false;
        }
        return true;
    }

    private boolean compare(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        for (int i = 0; i < n && i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
        }
        return n > m;
    }
}
