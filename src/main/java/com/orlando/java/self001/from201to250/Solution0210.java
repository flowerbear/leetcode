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

  // 记录后序遍历结果
  List<Integer> postorder = new ArrayList<>();
  // 记录是否存在环
  boolean hasCycle = false;
  boolean[] visited, onPath;

  // 主函数
  public int[] findOrder1(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = buildGraph(numCourses, prerequisites);
    visited = new boolean[numCourses];
    onPath = new boolean[numCourses];
    // 遍历图
    for (int i = 0; i < numCourses; i++) {
      traverse(graph, i);
    }
    // 有环图无法进行拓扑排序
    if (hasCycle) {
      return new int[]{};
    }
    // 逆后序遍历结果即为拓扑排序结果
    Collections.reverse(postorder);
    int[] res = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      res[i] = postorder.get(i);
    }
    return res;
  }

  // 图遍历函数
  void traverse(List<Integer>[] graph, int s) {
    if (onPath[s]) {
      // 发现环
      hasCycle = true;
    }
    if (visited[s] || hasCycle) {
      return;
    }
    // 前序遍历位置
    onPath[s] = true;
    visited[s] = true;
    for (int t : graph[s]) {
      traverse(graph, t);
    }
    // 后序遍历位置
    postorder.add(s);
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
