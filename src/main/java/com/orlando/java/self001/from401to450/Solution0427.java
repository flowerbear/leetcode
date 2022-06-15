package com.orlando.java.self001.from401to450;

/*
 * Construct Quad Tree
 *
 * Given a n * n matrix grid of 0's and 1's only. We want to represent the grid with a Quad-Tree.
 *
 * Return the root of the Quad-Tree representing the grid.
 *
 * Notice that you can assign the value of a node to True or False when isLeaf is False, and both are accepted in
 * the answer.
 *
 * A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has
 * two attributes:
 *
 *   > val: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
 *   > isLeaf: True if the node is leaf node on the tree or False if the node has the four children.
 *
 * We can construct a Quad-Tree from a two-dimensional area using the following steps:
 *
 *   > If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of
 *     the grid and set the four children to Null and stop.
 *   > If the current grid has different values, set isLeaf to False and set val to any value and divide the current
 *     grid into four sub-grids as shown in the photo.
 *   > Recurse for each of the children with the proper sub-grid.
 *
 */
public class Solution0427 {

  class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  }

  public Node construct(int[][] grid) {
    return helper(grid, 0, 0, grid.length);
  }

  private Node helper(int[][] grid, int x, int y, int length) {
    if (length == 1) return new Node(grid[x][y] != 0, true, null, null, null, null);
    Node result = new Node();
    Node topLeft = helper(grid, x, y, length / 2);
    Node topRight = helper(grid, x, y + length / 2, length / 2);
    Node bottomLeft = helper(grid, x + length / 2, y, length / 2);
    Node bottomRight = helper(grid, x + length / 2, y + length / 2, length / 2);
    if (topLeft.isLeaf
        && topRight.isLeaf
        && bottomLeft.isLeaf
        && bottomRight.isLeaf
        && topLeft.val == topRight.val
        && topRight.val == bottomLeft.val
        && bottomLeft.val == bottomRight.val) {
      result.isLeaf = true;
      result.val = topLeft.val;
    } else {
      result.topLeft = topLeft;
      result.topRight = topRight;
      result.bottomLeft = bottomLeft;
      result.bottomRight = bottomRight;
    }
    return result;
  }
}

