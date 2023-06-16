package com.orlando.java.self001.from1551to1600;

import com.orlando.java.common.UF;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution1584 {

    int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                edges.add(new int[]{i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});

        Collections.sort(edges, (a, b) -> { return a[2] - b[2]; });

        int mst = 0;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (uf.connected(edge[0], edge[1])) continue;
            mst += edge[2];
            uf.union(edge[0], edge[1]);
        }
        return mst;
    }

    public static void main(String[] args) {
        Solution1584 temp = new Solution1584();
        System.out.printf("%d", temp.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
    }
}
