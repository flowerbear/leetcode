package com.orlando.java.self001.from351to400;

import java.util.*;

/*
 * Evaluate Division
 *
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] =
 * [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a
 * single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the
 * answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero
 * and that there is no contradiction.
 *
 */
public class Solution0399 {

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

    Map<String, Map<String, Double>> graph = buildGraph(equations, values);
    double[] result = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
      result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>(), graph);
    }

    return result;
  }

  private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
    if (!graph.containsKey(start)) return -1.0;

    if (graph.get(start).containsKey(end)) return graph.get(start).get(end);

    visited.add(start);
    for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
      if (!visited.contains(neighbour.getKey())) {
        double productWeight = getPathWeight(neighbour.getKey(), end, visited, graph);
        if (productWeight != -1.0) {
          return neighbour.getValue() * productWeight;
        }
      }
    }
    return -1.0;
  }

  private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    String u, v;

    for (int i = 0; i < equations.size(); i++) {
      u = equations.get(i).get(0);
      v = equations.get(i).get(1);
      graph.putIfAbsent(u, new HashMap<>());
      graph.get(u).put(v, values[i]);
      graph.putIfAbsent(v, new HashMap<>());
      graph.get(v).put(u, 1/ values[i]);
    }

    return graph;
  }
}

