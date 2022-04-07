package com.orlando.java.self001;

import java.util.*;

/*
 * Minimum Weighted Sbgraph With the Required Paths
 *
 * You are given an integer n denoting the number of nodes of a weighted directed graph. The nodes are numbered from
 * 0 to n - 1.
 *
 * You are also given a 2D integer array edges where edges[i] = [fromi, toi, weighti] denotes that there exists a
 * directed edge from fromi to toi with weight weighti.
 *
 * Lastly, you are given three distinct integers src1, src2, and dest denoting three distinct nodes of the graph.
 *
 * Return the minimum weight of a subgraph of the graph such that it is possible to reach dest from both src1 and
 * src2 via a set of edges of this subgraph. In case such a subgraph does not exist, return -1.
 *
 * A subgraph is a graph whose vertices and edges are subsets of the original graph. The weight of a subgraph is
 * the sum of weights of its constituent edges.
 *
 */
public class Solution2203 {

  private static final int ONLY_1 = 1;
  private static final int ONLY_2 = 2;
  private static final int BOTH = 3;

  private static class NodeCostPair {
    int to;
    long weight;
    public NodeCostPair(int to, long weight) {
      this.to = to; this.weight = weight;
    }
  }

  private static class SearchNode implements Comparable<SearchNode> {

    int to;
    long cost;
    int type;

    public SearchNode(int to, long cost, int type) {
      this.to = to; this.cost = cost; this.type = type;
    }

    @Override
    public int compareTo(SearchNode o) {
      if (this.cost < o.cost) return -1;
      else if (this.cost> o.cost) return 1;
      else {
        if (this.type == BOTH) return -1;
      }
      return 1;
    }
  }

  private static long dijkstra(Map<Integer, List<NodeCostPair>> map, int src_1, int src_2, int dest) {
    int n = map.size();
    long[] dist_1 = new long[n];
    long[] dist_2 = new long[n];
    long[] dist = new long[n];

    Arrays.fill(dist_1, -1);
    Arrays.fill(dist_2, -1);
    Arrays.fill(dist, -1);

    PriorityQueue<SearchNode> pq = new PriorityQueue<>();
    pq.add(new SearchNode(src_1, 0, ONLY_1));
    pq.add(new SearchNode(src_2, 0, ONLY_2));

    while(!pq.isEmpty()) {
      SearchNode node = pq.poll();
      int cur = node.to, type = node.type;
      long cost = node.cost;

      if (type == ONLY_1) {
        if (dist_1[cur] != -1) continue;
        dist_1[cur] = cost;
        List<NodeCostPair> neighbours = map.get(cur);
        if (dist_2[cur] != -1) {
          pq.add(new SearchNode(cur, dist_1[cur] + dist_2[cur], BOTH));
        }
        //} else {
          for (NodeCostPair e : neighbours) {
            pq.add(new SearchNode(e.to, dist_1[cur] + e.weight, ONLY_1));
          }
        //}
      } else if (type == ONLY_2) {
        if (dist_2[cur] != -1) continue;
        dist_2[cur] = cost;
        List<NodeCostPair> neighbours = map.get(cur);
        if (dist_1[cur] != -1) {
          pq.add(new SearchNode(cur, dist_1[cur] + dist_2[cur], BOTH));
        }
        //} else {
          for (NodeCostPair e :neighbours) {
            pq.add(new SearchNode(e.to, dist_2[cur] + e.weight, ONLY_2));
          }
        //}
      } else {
        if (dist[cur] != -1) continue;
        if (cur == dest) {
          return cost;
        }
        dist[cur] = cost;
        List<NodeCostPair> neighbours = map.get(cur);
        for (NodeCostPair e : neighbours) {
          pq.add(new SearchNode(e.to, dist[cur] + e.weight, BOTH));
        }
      }
    }
    return -1;
  }

  public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
    Map<Integer, List<NodeCostPair>> map = new HashMap<>();
    for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
    for (int[] edge : edges) {
      int from = edge[0], to = edge[1], weight = edge[2];
      map.get(from).add(new NodeCostPair(to, weight));
    }
    return dijkstra(map, src1, src2, dest);
  }

  private long[] dijkstra(List<int[]>[] graph, int n, int src) {
    long[] dist = new long[n];
    Arrays.fill(dist, Long.MAX_VALUE);
    dist[src] = 0;
    PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
    minHeap.offer(new long[]{0, src}); // dist, src
    while (!minHeap.isEmpty()) {
      long[] top = minHeap.poll();
      long d = top[0];
      int u = (int) top[1];
      if (d > dist[u]) continue;
      for (int[] nei : graph[u]) {
        int v = nei[0], time = nei[1];
        if (dist[v] > d + time) {
          dist[v] = d + time;
          minHeap.offer(new long[]{dist[v], v});
        }
      }
    }
    return dist;
  }

  public static void main(String[] args) {
    Solution2203 temp = new Solution2203();
    System.out.println(temp.minimumWeight(4, new int[][]{{0, 2, 2}, {3, 1, 1}, {2,3,2}, {3,2,1}}, 3, 0, 1));
  }
}
