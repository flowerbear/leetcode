package com.orlando.java.self001.from451to500;

import java.util.Random;
import java.util.TreeMap;

public class Solution0497 {

    TreeMap<Integer, Integer> map;
    int[][] arrays;
    int sum;
    Random rnd = new Random();
    public Solution0497(int[][] rects) {
        this.arrays = rects;
        map = new TreeMap<>();
        sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(sum, i);
        }
    }

    public int[] pick() {
        // lowerKey(K key): returns the greatest key strictly less than the given key.
        //  floorKey(K key): returns the greatest key less than or equal to the given key.
        //  ceilingKey(K key): returns the least key greater than or equal to the given key.
        //  higherKey(K key): returns the least key strictly greater than the given key.
        int c = map.ceilingKey(rnd.nextInt(sum) + 1);
        return pickInRect(arrays[map.get(c)]);
    }

    private int[] pickInRect(int[] rect) {
        int left = rect[0], right = rect[2], bot = rect[1], top = rect[3];
        return new int[]{left + rnd.nextInt(right -left + 1), bot + rnd.nextInt(top - bot + 1)};
    }
}

