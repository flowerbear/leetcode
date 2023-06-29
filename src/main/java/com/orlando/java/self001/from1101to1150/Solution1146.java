package com.orlando.java.self001.from1101to1150;

import java.util.TreeMap;

public class Solution1146 {
    TreeMap<Integer, Integer>[] A;
    int snap_id = 0;

    public Solution1146(int length) {
        A = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            A[i] = new TreeMap<>();
            A[i].put(this.snap_id, 0);
        }
    }

    public void set(int index, int val) {
        A[index].put(snap_id, val);
    }

    public int snap() {
        return this.snap_id++;
    }

    public int get(int index, int snap_id) {
        return A[index].floorEntry(snap_id).getValue();
    }
}
