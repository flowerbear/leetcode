package com.orlando.java.geeksforgeeks.problem2;

import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Trailing zeroes in factorial
 *
 * For an integer N find the number of trailing zeroes in N!.
 *
 */
public class GFG {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      Solution sln = new Solution();
      System.out.println(sln.trailingZeros(n));
    }
  }
}

class Solution {
  int trailingZeros(int n) {
    int result = 0;
    for (int i = 5; n / i >= 1; i *= 5) {
      result += n / i;
    }
    return result;
  }
}