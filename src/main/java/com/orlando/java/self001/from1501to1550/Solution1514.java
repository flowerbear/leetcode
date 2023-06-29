package com.orlando.java.self001.from1501to1550;

import java.util.*;

public class Solution1514 {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            adjMap.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});
            adjMap.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});
        }
        double[] probaility = new double[n];
        probaility[start] = 1d;
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(start));
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] a : adjMap.getOrDefault(cur, Collections.emptyList())) {
                int neighbor = a[0], index = a[1];
                if (probaility[cur] * succProb[index] > probaility[neighbor]) {
                    probaility[neighbor] = probaility[cur] * succProb[index];
                    queue.offer(neighbor);
                }
            }
        }
        return probaility[end];
    }

    public double maxProbability1(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, Map<Integer, Double>> adjMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            adjMap.computeIfAbsent(a, l -> new HashMap<>()).put(b, succProb[i]);
            adjMap.computeIfAbsent(b, l -> new HashMap<>()).put(a, succProb[i]);
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[0]));
        double[] prob = new double[n];
        pq.offer(new double[]{1, start});
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int v = (int) cur[1];
            if (v == end) return cur[0];
            if (cur[0] > prob[v]) {
                prob[v] = cur[0];
                for (var entry : adjMap.getOrDefault(v, Map.of()).entrySet()) {
                    int nb = entry.getKey();
                    double p = entry.getValue();
                    pq.offer(new double[]{cur[0] * p, nb});
                }
            }
        }
        return 0d;
    }
}
