package com.orlando.java.self001.from151to200;

/*
 * Number of 1 Bits
 *
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has
 * (also known as the Hamming weight).
 *
 */
public class Solution0191 {

  public int hammingWeight(int n) {
    int result = 0;
    while (n != 0) {
      result += (n & 1);
      n >>>= 1;
    }
    return result;
  }
}
