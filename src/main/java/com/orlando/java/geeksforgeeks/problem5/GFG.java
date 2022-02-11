package com.orlando.java.geeksforgeeks.problem5;

import java.io.IOException;
import java.util.Scanner;

/**
 * Smallest Positive Integer that can not be represented as Sum
 *
 * Given an array of size N, find the smallest positive integer value that cannot be
 * represented as sum of some elements from the array.
 *
 */
public class GFG {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      long[] array = new long[n];
      for (int i = 0; i < n; i++) {
        array[i] = sc.nextLong();
      }
      Solution sln = new Solution();
      System.out.println(sln.smallestPositive(array, n));
    }
  }
}

class Solution {
  long smallestPositive(long[] array, int n) {
    long smallest = Long.MAX_VALUE, secondSmallest = Long.MAX_VALUE;
    long sum = 0l;
    for (int i = 0; i < array.length; i++) {
      sum = array[i];
      if (sum <= smallest) {
        smallest = sum;
      } else if (sum <= secondSmallest)
      for (int j = i; j < array.length; j++) {
      }
    }
    return 100l;
  }
}