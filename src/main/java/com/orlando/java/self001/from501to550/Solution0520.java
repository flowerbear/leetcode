package com.orlando.java.self001.from501to550;

public class Solution0520 {

    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for (char c : word.toCharArray())
            if ('Z' - c >= 0) cnt++;
        return ((cnt == 0 || cnt == word.length()) || (cnt == 1 && 'Z' - word.charAt(0) >= 0));
    }
}

