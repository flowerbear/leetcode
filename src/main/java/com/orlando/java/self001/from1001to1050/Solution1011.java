package com.orlando.java.self001.from1001to1050;

public class Solution1011 {

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2, need = 1, cur = 0;
            for (int w : weights) {
                if (cur + w > mid) {
                    need++;
                    cur = 0;
                }
                cur += w;
            }
            if (need > days) left = mid + 1;
            else right = mid;
        }
        return left;
    }

}
