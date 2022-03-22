package com.orlando.java.self001.from201to250;

/*
 * Count Primes
 *
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 */
public class Solution0204 {

  public int countPrimes(int n) {
    if (n <= 1) return 0;

    boolean[] notPrime = new boolean[n];
    notPrime[0] = true;
    notPrime[1] = true;
    int sqrtN = (int) Math.sqrt(n);
    for (int i = 2; i <= sqrtN; i++) {
      if (!notPrime[i]) {
        for (int j = 2; j * i < n; j++) {
          notPrime[i * j] = true;
        }
      }
    }

    int count = 0;
    for (int i = 2; i < notPrime.length; i++) {
      if (!notPrime[i]) count++;
    }
    return count;
  }
}
