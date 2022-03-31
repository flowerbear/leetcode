package com.orlando.java.self001.from251to300;

/*
 * Perfect Squares
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some
 * integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 */
public class Solution0279 {

  public int numSquares(int n) {
    if (isSquare(n)) return 1;
    while ((n & 3) == 0) {
      n >>= 2;
    }
    if ((n & 7) == 7) return 4;

    int sqrtN = (int) Math.sqrt(n);
    for (int i = 1; i <= sqrtN; i++) {
      if (isSquare(n - i * i)) return 2;
    }

    return 3;
  }

  private boolean isSquare(int n) {
    int sqrtN = (int)Math.sqrt(n);
    return (sqrtN * sqrtN) == n;
  }

  public int numSquares1(int n) {
    int result = n;
    int num = 2;
    while (num * num <= n) {
      int temp1 = n / (num * num);
      int temp2 = n % (num * num);
      result = Math.min(result, temp1 + numSquares(temp2));
      num++;
    }
    return result;
  }
}
