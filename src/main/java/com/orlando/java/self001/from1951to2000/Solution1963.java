package com.orlando.java.self001.from1951to2000;

public class Solution1963 {

    public int minSwaps(String s) {
        int misMatch = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') misMatch++;
            else {
                if (misMatch > 0) misMatch--;
            }
        }
        return (misMatch + 1) / 2;
    }
}
