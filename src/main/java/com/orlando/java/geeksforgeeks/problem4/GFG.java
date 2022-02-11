package com.orlando.java.geeksforgeeks.problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Nth Natural Number
 *
 * Given a positive integer N. You have to find Nth natural number after removing all
 * the numbers containing digit 9.
 *
 */
public class GFG {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      long n = sc.nextLong();
      Solution sln = new Solution();
      System.out.println(sln.findNth(n));
    }
  }
}

class Solution {
  long findNth(long N) {
    return Long.valueOf(Long.toString(N, 9));
  }
}