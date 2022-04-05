package com.orlando.java.self001.from251to300;

import com.orlando.java.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * Serialize and Deserialize Binary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not
 * necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 */
public class Solution0297 {

  private static final String SPLITER = ",";
  private static final String NN = "X";

  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();

    buildString(root, sb);
    return sb.toString();
  }

  private void buildString(TreeNode root, StringBuilder sb) {
    if (root == null) sb.append(NN).append(SPLITER);
    else {
      sb.append(root.val).append(SPLITER);
      buildString(root.left, sb);
      buildString(root.right, sb);
    }
  }

  public TreeNode deserialize(String data) {
    LinkedList<String> nodes = new LinkedList<>();
    nodes.addAll(Arrays.asList(data.split(SPLITER)));
    return buildTree(nodes);
  }

  private TreeNode buildTree(LinkedList<String> nodes) {
    String val = nodes.remove();
    if (val.equals(NN)) return null;
    else {
      TreeNode node = new TreeNode(Integer.valueOf(val));
      node.left = buildTree(nodes);
      node.right = buildTree(nodes);
      return node;
    }
  }
}
