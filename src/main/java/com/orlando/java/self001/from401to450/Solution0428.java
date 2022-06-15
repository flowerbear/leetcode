package com.orlando.java.self001.from401to450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Serialize and Deserialize N-ary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each
 * node has no more than N children. There is no restriction on how your serialization/deserialization algorithm
 * should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be
 * deserialized to the original tree structure.
 *
 */
public class Solution0428 {

  class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  private static final String SPLITER = ",";
  private static final String NULL_NODE = "#";

  public String serialize(Node root) {
    StringBuilder sb = new StringBuilder();
    buildString(root, sb);
    return sb.toString();
  }

  private void buildString(Node node, StringBuilder sb) {
    if (node == null)
      sb.append(NULL_NODE).append(SPLITER).append(0);
    else {
      sb.append(node.val).append(SPLITER).append(node.children.size());
      for (Node child : node.children) {
        buildString(child, sb);
      }
    }
  }

  public Node deserialize(String data) {
    if (data.length() == 0) return null;
    LinkedList<String> nodeList = new LinkedList<>();
    nodeList.addAll(Arrays.asList(data.split(SPLITER)));
    return buildTree(nodeList);
  }

  private Node buildTree(LinkedList<String> nodes) {
    String val = nodes.removeFirst();
    if (val.equals(NULL_NODE)) {
      return null;
    } else {
      Node node = new Node();
      node.val = Integer.valueOf(val);
      int size = Integer.valueOf(nodes.removeFirst());
      node.children = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        node.children.add(buildTree(nodes));
      }
      return node;
    }
  }
}

