package com.orlando.java.self001.from751to800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution0787 {

    int[][] memo;
    HashMap<Integer, List<int[]>> indegree;
    int src, dst;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        this.src = src;
        this.dst = dst;
        indegree = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0], to = f[1], price = f[2];
            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[]{from, price});
        }
        memo = new int[n][k + 1];
        for (int[] row : memo) Arrays.fill(row, -888);
        return dp(dst, k);
    }

    private int dp(int s, int k) {
        if (s == src) return 0;
        if (k == 0) return -1;
        if (memo[s][k] != -888) return memo[s][k];
        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            for (int[] v : indegree.get(s)) {
                int from = v[0], price = v[1];
                int subProblem = dp(from, k - 1);
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];

    }


    // Bellman ford algorithm
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}

