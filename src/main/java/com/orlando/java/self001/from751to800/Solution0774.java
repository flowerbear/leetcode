package com.orlando.java.self001.from751to800;

public class Solution0774 {

    public double minmaxGasDist(int[] stations, int K) {
        int n = stations.length;
        double l = 0.0, h = stations[n - 1] - stations[0];
        while (h - l > 1e-6) {
            double mid = l + (h - l) / 2;
            int minStat = 0;
            for (int i = 1; i < n; i++) {
                minStat += (int) ((stations[i] - stations[i - 1]) / mid);
            }
            if (minStat <= K) h = mid;
            else l = mid;
        }
        return l;
    }
}

