package com.orlando.java.geeksforgeeks.problem1;

import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Missing number in array
 *
 * Given an array of size N-1 such that it only contains distinct integers
 * in the range of 1 to N. Find the missing element.
 *
 */
public class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bf.readLine().trim());

    while (t-- > 0) {
      int n = Integer.parseInt(bf.readLine().trim());
      String[] str = bf.readLine().trim().split(" ");
      int[] array = new int[n - 1];
      for (int i = 0; i < n - 1; i++) {
        array[i] = Integer.parseInt(str[i]);
      }

      Solution sln = new Solution();
      System.out.println(sln.MissingNumber(array, n));
    }
  }
}

class Solution {
  int MissingNumber(int array[], int n) {
    int result = 0;
    for (int i = 0; i < n - 1; i++) {
      result ^= array[i];
      result ^= (i + 1);
    }
    return result ^ n;
  }
}