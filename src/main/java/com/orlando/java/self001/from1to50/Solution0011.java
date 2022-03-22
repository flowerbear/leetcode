package com.orlando.java.self001.from1to50;

/*
 * Container With Most Water
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 */
public class Solution0011 {

  // Start with the widest container and move shorter line and check result
  public int maxArea(int[] height) {
    int i = 0, j = height.length - 1, result = 0;
    while (i < j) {
      result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return result;
  }
}
