package com.orlando.java.self001.from451to500;

public class Solution0466 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int l1 = s1.length(), l2 = s2.length();
        int[] next = new int[l2 + 1];
        int[] count = new int[l2 + 1];
        int cnt = 0, p = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < l1; j++) {
                if (s1.charAt(j) == s2.charAt(p)) {
                    p++;
                }
                if (p == l2) {
                    cnt++;
                    p = 0;
                }
            }
            count[i] = cnt;
            next[i] = p;
            for (int j = 0; j < i; j++) {
                if (next[j] == p) {
                    int prev_count = count[j];
                    int pattern_count = (count[i] - count[j]) * ((n1 - j - 1) / (i - j));
                    int remain_count = count[j + (n1 - j - 1) % (i - j)] - count[j];
                    return (prev_count + pattern_count + remain_count) / n2;
                }
            }
        }
        return count[n1 - 1] / n2;
    }

    public int getMaxRepetitions1(String s1, int n1, String s2, int n2) {
        char[] array1 = s1.toCharArray(), array2 = s2.toCharArray();
        int count1 = 0, count2 = 0, i = 0, j = 0;
        while (count1 < n1) {
            if (array1[i] == array2[j]) {
                j++;
                if (j == array2.length) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == array1.length) {
                i = 0;
                count1++;
            }
        }
        return count2 / n2;
    }
}

