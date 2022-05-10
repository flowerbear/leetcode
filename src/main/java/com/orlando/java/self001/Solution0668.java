package com.orlando.java.self001;

/*
 * Kth Smallest Number in Multiplication Table
 *
 * Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat
 * where mat[i][j] == i * j (1-indexed).
 *
 * Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.
 *
 */
public class Solution0668 {

  public int findKthNumber(int m, int n, int k) {
    int l = 1, r = m * n;
    while (l < r) {
      int mid = l + (r - l) / 2;
      int c = count(mid, m, n);
      if (c >= k) r = mid;
      else l = mid + 1;
    }
    return r;
  }

  private int count(int mid, int m, int n) {

    int count = 0;
    for (int i = 1; i <= m; i++) {
      int temp = Math.min(mid / i, n);
      count += temp;
    }
    return count;
  }
}
