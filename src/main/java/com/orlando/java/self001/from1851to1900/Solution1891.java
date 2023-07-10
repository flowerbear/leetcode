package com.orlando.java.self001.from1851to1900;

public class Solution1891 {
    public int maxLength(int[] ribbons, int k) {
        int l = 0, r = 100000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int x : ribbons) {
                cnt += x / mid;
            }
            if (cnt >= k) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
