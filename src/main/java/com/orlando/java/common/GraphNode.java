package com.orlando.java.common;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
  public int val;
  public List<GraphNode> neighbors;

  public GraphNode() {
    this.val = 0;
    this.neighbors = new ArrayList<>();
  }

  public GraphNode(int _val) {
    this.val = _val;
    this.neighbors = new ArrayList<>();
  }

  public  GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
    this.val = _val;
    this.neighbors = _neighbors;
  }
}
