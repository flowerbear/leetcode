package com.orlando.java.leetcode;

import java.util.*;

public class Solution0207 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    int[] indegree = new int[numCourses];

    for (int i = 0; i < prerequisites.length; i++) {
      int src = prerequisites[i][1];
      int dest = prerequisites[i][0];
      List<Integer> temp = adjMap.getOrDefault(src, new ArrayList<>());
      temp.add(dest);
      adjMap.put(src, temp);

      indegree[dest]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    int i = 0;
    while (!queue.isEmpty()) {
      int node = queue.remove();
      i++;

      if (adjMap.containsKey(node)) {
        for (Integer neighbor : adjMap.get(node)) {
          indegree[neighbor]--;
          if (indegree[neighbor] == 0) {
            queue.add(neighbor);
          }
        }
      }
    }

    return i == numCourses;
  }
}
