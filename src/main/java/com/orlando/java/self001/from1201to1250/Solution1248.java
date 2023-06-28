package com.orlando.java.self001.from1201to1250;

import java.util.HashMap;

public class Solution1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, csum = 0, res = 0;
        int[] map = new int[n + 1];
        map[0] = 1;
        for (int i = 0; i < n; i++) {
            csum += nums[i] % 2 == 0 ? 0 : 1;
            map[csum]++;
            res += csum >= k ? map[csum - k] : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1248 temp = new Solution1248();
        temp.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);
    }
}
