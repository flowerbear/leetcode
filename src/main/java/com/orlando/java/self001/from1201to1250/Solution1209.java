package com.orlando.java.self001.from1201to1250;

public class Solution1209 {


    public String removeDuplicates(String s, int k) {
        int n = s.length(), i = 0, count[] = new int[n];
        char[] res = s.toCharArray();
        for (int j = 0; j < n; j++, i++) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) count[i] = count[i - 1] + 1;
            else count[i] = 1;
            if (count[i] == k) i -= k;
        }
        return new String(res, 0, i);
    }
}
