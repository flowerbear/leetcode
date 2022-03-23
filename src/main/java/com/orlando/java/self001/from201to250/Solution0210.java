package com.orlando.java.self001.from201to250;

import java.util.*;

/*
 * Course Schedule II
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return
 * any of them. If it is impossible to finish all courses, return an empty array.
 *
 */
public class Solution0210 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] result = new int[numCourses], indegree = new int[numCourses];
    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    for (int i = 0; i < prerequisites.length; i++) {
      int src = prerequisites[i][1], dest = prerequisites[i][0];
      List<Integer> temp = adjMap.getOrDefault(src, new ArrayList<>());
      temp.add(dest);
      adjMap.put(src, temp);
      indegree[dest]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) queue.add(i);
    }

    int i = 0;
    while (!queue.isEmpty()) {
      int node = queue.remove();
      result[i++] = node;
      if (adjMap.containsKey(node)) {
        for (Integer neighbor : adjMap.get(node)) {
          indegree[neighbor]--;
          if (indegree[neighbor] == 0) queue.add(neighbor);
        }
      }
    }
    if (i == numCourses) return result;
    else return new int[0];
  }
}
