package com.orlando.java.self001.from451to500;

public class Solution0459 {

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, -1).contains(s);
    }

    // 100% KMP
    public boolean repeatedSubstringPattern1(String s) {
        int n = s.length(), len = 0, lpsTable[] = new int[n];
        for (int i = 1; i < n; i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) len = lpsTable[len - 1];
            if (s.charAt(i) == s.charAt(len)) len++;
            lpsTable[i] = len;
        }
        return lpsTable[n-1] != 0 && (lpsTable[n-1] % (n - lpsTable[n-1])) == 0;
    }
}

