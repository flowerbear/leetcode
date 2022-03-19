package com.orlando.java.self001;

import com.orlando.java.common.TreeNode;

import java.util.Stack;

/*
 * Binary Search Tree Iterator
 *
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a
 * binary search tree (BST):
 *
 *   > BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as
 *    part of the constructor. The pointer should be initialized to a non-existent number smaller than any element
 *    in the BST.
 *   >boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer,
 *    otherwise returns false.
 *   >int next() Moves the pointer to the right, then returns the number at the pointer.
 *
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will
 * return the smallest element in the BST.
 *
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the
 * in-order traversal when next() is called.
 *
 */
public class Solution0173 {

  private Stack<TreeNode> stack = new Stack<>();

  public Solution0173(TreeNode root) {
    pushAll(root);
  }

  private void pushAll(TreeNode root) {
    for (; root != null; stack.push(root), root = root.left);
  }

  public int next() {
    TreeNode tempNode = stack.pop();
    pushAll(tempNode.right);
    return tempNode.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }
}
