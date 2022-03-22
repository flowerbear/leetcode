package com.orlando.java.self001.from1to50;

/*
 * Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it can trap after raining.
 *
 */
public class Solution0042 {

  public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int result = 0, left_max = 0, right_max = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] > left_max) {
          left_max = height[left];
        } else {
          result += (left_max - height[left]);
        }
        left++;
      } else {
        if (height[right] > right_max) {
          right_max = height[right];
        } else {
          result += (right_max - height[right]);
        }
        right--;
      }
    }
    return result;
  }
}
