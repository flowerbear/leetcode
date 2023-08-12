package com.orlando.java.self001.from451to500;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution0487 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, zeros = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) zeros++;
            while (zeros == 2) {
                if (nums[l++] == 0) zeros--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int maxZeros = 1, res = 0;
        Queue<Integer> q = new ArrayDeque<>();

        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) q.offer(r);
            if (q.size() > maxZeros) l = q.poll() + 1;
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int ans = 0;
        int lastZeroIndex = -1;

        for (int l = 0, r = 0; r < nums.length; ++r) {
            if (nums[r] == 0) {
                l = lastZeroIndex + 1;
                lastZeroIndex = r;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}

