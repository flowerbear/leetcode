package com.orlando.java.self001;

import com.orlando.java.common.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Clone Graph
 *
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 */
public class Solution0133 {

  private Map<Integer, GraphNode> map = new HashMap<>();
  public GraphNode cloneGraph(GraphNode node) {
    return clone(node);
  }

  private GraphNode clone(GraphNode node) {
    if (node == null) return null;

    if (map.containsKey(node.val))
      return map.get(node.val);

    GraphNode newNode = new GraphNode(node.val, new ArrayList<>());
    map.put(newNode.val, newNode);
    for (GraphNode neighbor : node.neighbors) {
      newNode.neighbors.add(clone(neighbor));
    }
    return newNode;
  }
}
