package com.orlando.java.self001.from201to250;

import java.util.*;

/*
 * Course Schedule
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an
 * array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *
 * Return true if you can finish all courses. Otherwise, return false.
 *
 */
public class Solution0207 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    int[] indegree = new int[numCourses];

    for (int i = 0; i < prerequisites.length; i++) {
      List<Integer> temp = adjMap.getOrDefault(prerequisites[i][1], new ArrayList<>());
      temp.add(prerequisites[i][0]);
      adjMap.put(prerequisites[i][1], temp);
      indegree[prerequisites[i][0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) queue.add(i);
    }

    int i = 0;
    while (!queue.isEmpty()) {
      int node = queue.remove();
      i++;
      if (adjMap.containsKey(node)) {
        for (Integer neighbor : adjMap.get(node)) {
          indegree[neighbor]--;
          if (indegree[neighbor] == 0) queue.add(neighbor);
        }
      }
    }
    return (i == numCourses);
  }

  boolean[] onPath;
  boolean[] visited;
  boolean hasCycle = false;
  public boolean canFinishDFS(int numCourses, int[][] prerequisties) {
    List<Integer>[] graph = buildGraph(numCourses, prerequisties);

    visited = new boolean[numCourses];
    onPath = new boolean[numCourses];

    for (int i = 0; i < numCourses; i++) {
      traverse(graph, i);
    }
    return !hasCycle;
  }

  private void traverse(List<Integer>[] graph, int s) {
    if (onPath[s]) hasCycle = true;
    if (visited[s] || hasCycle) return;
    visited[s] = true;
    onPath[s] = true;
    for (int t : graph[s]) {
      traverse(graph, t);
    }
    onPath[s] = false;
  }

  private List<Integer>[] buildGraph(int numCourses, int[][] prerequisties) {
    List<Integer>[] graph = new LinkedList[numCourses];
    for (int i = 0; i < numCourses; i++) graph[i] = new LinkedList<>();
    for (int[] edge : prerequisties) {
      graph[edge[1]].add(edge[0]);
    }
    return graph;
  }
}
