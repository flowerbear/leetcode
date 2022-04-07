package com.orlando.java.self001.from301to350;

/*
 * Super Ugly Number
 *
 * A super ugly number is a positive integer whose prime factors are in the array primes.
 *
 * Given an integer n and an array of integers primes, return the nth super ugly number.
 *
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 */
public class Solution0313 {

  public int nthSuperUglyNumber(int n, int[] primes) {
    int[] ugly = new int[n];
    int[] idx = new int[primes.length];

    ugly[0] = 1;
    for (int i = 1; i < n; i++) {
      ugly[i] = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
      }

      for (int j = 0; j < primes.length; j++) {
        if (ugly[i] == primes[j] * ugly[idx[j]]) idx[j]++;
      }
    }
    return ugly[n - 1];
  }

  public int nthSuperUglyNumber1(int n, int[] primes) {
    int[] ugly = new int[n];
    int[] idx = new int[primes.length];

    ugly[0] = 1;
    for (int i = 1; i < n; i++) {
      ugly[i] = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        if (primes[j] * ugly[idx[j]] == ugly[i - 1]) idx[j]++;

        ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
      }
    }
    return ugly[n - 1];
  }
}

