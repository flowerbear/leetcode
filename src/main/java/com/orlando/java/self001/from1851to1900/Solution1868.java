package com.orlando.java.self001.from1851to1900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1868 {

    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < encoded1.length && j < encoded2.length) {
            int mult = encoded1[i][0] * encoded2[j][0];
            int minFreq = Math.min(encoded1[i][1], encoded2[j][1]);
            if (!res.isEmpty() && mult == res.get(res.size() - 1).get(0)) {
                res.get(res.size() - 1).set(1, res.get(res.size() - 1).get(1) + minFreq);
            } else {
                res.add(Arrays.asList(mult, minFreq));
            }
            encoded1[i][1] -= minFreq;
            encoded2[j][1] -= minFreq;
            if (encoded1[i][1] == 0) i++;
            if (encoded2[j][1] == 0) j++;
        }
        return res;
    }
}
