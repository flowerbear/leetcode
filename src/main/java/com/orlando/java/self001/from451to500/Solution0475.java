package com.orlando.java.self001.from451to500;

import java.util.Arrays;

public class Solution0475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) i++;
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }
}

