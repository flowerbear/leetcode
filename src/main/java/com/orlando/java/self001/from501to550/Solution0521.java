package com.orlando.java.self001.from501to550;

public class Solution0521 {

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}

