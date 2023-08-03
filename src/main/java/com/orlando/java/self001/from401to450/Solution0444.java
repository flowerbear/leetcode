package com.orlando.java.self001.from401to450;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution0444 {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs == null) return false;
        final int n = org.length;
        List<Integer>[] adjMap = new List[n];
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) adjMap[i] = new ArrayList<>();

        for (List<Integer> seq : seqs) {
            if (seq.size() == 1 && seq.get(0) < 1 || seq.get(0) > n) return false;
            for (int i = 0; i + 1 < seq.size(); i++) {
                final int u = seq.get(i), v = seq.get(i + 1);
                if (u < 1 || u > n || v < 1 || u > n) return false;
                adjMap[u - 1].add(v - 1);
                inDegree[v - 1]++;
            }
        }

        Queue<Integer> q = IntStream.range(0, n).filter(i -> inDegree[i] == 0).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        int i = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1) return false;
            final int u = q.poll();
            if (u != org[i] - 1) return false;
            i++;
            for (final int v : adjMap[u]) {
                if (--inDegree[v] == 0) q.offer(v);
            }
        }
        return i == n;
    }
}

