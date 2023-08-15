package com.orlando.java.self001.from501to550;

import java.util.*;

public class Solution0519 {

    Map<Integer, Integer> map;
    int rows, cols, total;
    Random rand;
    public Solution0519(int m, int n) {
        this.rows = m;
        this.cols = n;
        map = new HashMap<>();
        reset();
        rand = new Random();
    }

    public int[] flip() {
        int r = rand.nextInt(total--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        map.put(total, x);
        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        //map.clear();
        total = rows * cols;
    }
}

