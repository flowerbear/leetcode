package com.orlando.java.leetcode;

import java.util.*;

/*
 * Course Schedule II
 *
 */
public class Solution0210 {
  public int[] findOrder(int numCourses, int[][] prerequisites) {

    Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
    int[] indegree = new int[numCourses];
    int[] result = new int[numCourses];

    for (int i = 0; i < prerequisites.length; i++) {
      int dest = prerequisites[i][0];
      int src = prerequisites[i][1];
      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
      lst.add(dest);
      adjList.put(src, lst);

      // Record in-degree of each vertex
      indegree[dest] += 1;
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int i = 0;
    while (!q.isEmpty()) {
      int node = q.remove();

      result[i++] = node;

      if (adjList.containsKey(node)) {
        for (Integer neighbor : adjList.get(node)) {
          indegree[neighbor]--;

          if (indegree[neighbor] == 0) {
            q.add(neighbor);
          }
        }
      }
    }

    if (i == numCourses) {
      return result;
    } else {
      return new int[0];
    }
  }
}
