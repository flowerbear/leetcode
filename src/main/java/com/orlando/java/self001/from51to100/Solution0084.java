package com.orlando.java.self001.from51to100;

/*
 * Largest Rectangle in Histogram
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 *
 * return the area of the largest rectangle in the histogram.
 *
 */
public class Solution0084 {

  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) return 0;

    int[] lessFromLeft = new int[heights.length];
    int[] lessFromRight = new int[heights.length];
    lessFromRight[heights.length - 1] = heights.length;
    lessFromLeft[0] = -1;

    for (int i = 1; i < heights.length; i++) {
      int p = i - 1;
      while (p >= 0 && heights[p] >= heights[i]) {
        p = lessFromLeft[p];
      }
      lessFromLeft[i] = p;
    }

    for (int i = heights.length - 2; i >= 0; i--) {
      int p = i + 1;

      while (p < heights.length && heights[p] >= heights[i]) {
        p = lessFromRight[p];
      }
      lessFromRight[i] = p;
    }

    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
    }
    return maxArea;
  }

  public static void main(String[] args) {
    Solution0084 temp = new Solution0084();
    temp.largestRectangleArea(new int[]{2,1,5,6,2,3});
  }
}
