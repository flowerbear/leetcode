package com.orlando.java.self001.from201to250;

/*
 * Rectangle Area
 *
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the
 * two rectangles.
 *
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
 *
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
 *
 */
public class Solution0223 {

  public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int left = Math.max(ax1, bx1), right = Math.max(Math.min(ax2, bx2), left);
    int bottom = Math.max(ay1, by1), top = Math.max(Math.min(ay2, by2), bottom);
    return (ax2 - ax1) * (ay2 - ay1) - (right - left) * (top - bottom) + (bx2 - bx1) * (by2 - by1);
  }
}
