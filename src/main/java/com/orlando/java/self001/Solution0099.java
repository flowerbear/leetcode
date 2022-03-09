package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

/*
 * Recover Binary Search Tree
 *
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were
 * swapped by mistake. Recover the tree without changing its structure.
 *
 */
public class Solution0099 {

  private void morrisTraversal(TreeNode root) {
    TreeNode temp = null;
    while (root != null) {
      if (root.left != null) {
        temp = root.left;
        while (temp.right != null && temp.right != root) {
          temp = temp.right;
        }

        if (temp.right != null) {
          temp.right = null;
          System.out.println(root.val);
          root = root.right;
        } else {
          temp.right = root;
          root = root.left;
        }
      } else {
        System.out.println(root.val);
        root = root.right;
      }
    }
  }

  // Morris Traversal
  public void recoverTree(TreeNode root) {
    TreeNode pre = null, first = null, second = null, temp = null;
    while (root != null) {
      if (root.left != null) {
        temp = root.left;
        while (temp.right != null && temp.right != root) {
          temp = temp.right;
        }
        if (temp.right != null) {
          if (pre != null && pre.val > root.val) {
            if (first == null) {
              first = pre;
            }
            second = root;
          }

          pre = root;
          temp.right = null;
          root = root.right;
        } else {
          temp.right = root;
          root = root.left;
        }
      } else {
        if (pre != null && pre.val > root.val) {
          if (first == null) {
            first = pre;
          }
          second = root;
        }
        pre = root;
        root = root.right;
      }
    }
    if (first != null && second != null) {
      int t = first.val;
      first.val = second.val;
      second.val = t;
    }
  }
}
