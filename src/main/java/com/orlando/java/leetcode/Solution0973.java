package com.orlando.java.leetcode;

import java.util.Arrays;

public class Solution0973 {

  public int[][] kClosest(int[][] points, int k) {
    return quickSelect(points, k);
  }

  private int[][] quickSelect(int[][] points, int k) {
    int left = 0, right = points.length - 1;
    int pivotIndex = points.length;
    while (pivotIndex != k) {
      pivotIndex = partition(points, left, right);
      if (pivotIndex < k) {
        left = pivotIndex;
      } else {
        right = pivotIndex + 1;
      }
    }

    return Arrays.copyOf(points, k);
  }

  private int partition(int[][] points, int left, int right) {
    int[] pivot = choosePivot(points, left, right);
    int pivotDist = squaredDistance(pivot);
    while (left < right) {
      if (squaredDistance(points[left]) >= pivotDist) {
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
        right--;
      } else {
        left++;
      }
    }

    if (squaredDistance(points[left]) < pivotDist) left++;

    return left;
  }

  private int[] choosePivot(int[][] points, int left, int right) {
    return points[left + (right - left) / 2];
  }

  private int squaredDistance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }

  public int[][] kClosest1(int[][] points, int k) {
    return quickSelect1(points, k);
  }

  private int[][] quickSelect1(int[][] points, int k) {
    int l = 0, r = points.length - 1;
    int pivot = points.length;
    while (pivot != k) {
      pivot = partition(points, l, r);
      if (pivot < k) {
        l = pivot + 1;
      } else if (pivot > k) {
        r = pivot - 1;
      }
    }
    return Arrays.copyOf(points, k);
  }

  private int partition1(int[][] points, int l, int r) {
    int[] pivot = points[l];
    int left = l + 1, right = r;
    int pivotDist = squaredDistance(pivot);
    while (left <= right) {
      while (left < r && squaredDistance(points[left]) <= pivotDist) left++;
      while (right > l && squaredDistance(points[right]) > pivotDist) right--;
      if (left >= right) break;
      swap(points, left, right);
    }
    swap(points, l, right);
    return right;
  }

  private void swap(int[][] points, int l, int r) {
    int[] temp = points[l];
    points[l] = points[r];
    points[r] = temp;
  }

  public static void main(String[] args) {
    Solution0973 temp = new Solution0973();
    temp.kClosest1(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
  }
}
