package com.orlando.java.self001.from1101to1150;

import com.orlando.java.common.UF;

import java.util.Arrays;

public class Solution1135 {

    int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n + 1);
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        int mst = 0;
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1], weight = edge[2];
            if (uf.connected(u, v)) continue;
            mst += weight;
            uf.union(u, v);
        }

        return uf.count() == 2 ? mst : -1;
    }
}
