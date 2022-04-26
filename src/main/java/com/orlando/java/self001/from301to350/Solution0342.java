package com.orlando.java.self001.from301to350;

/*
 * Power of Four
 *
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 *
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 *
 */
public class Solution0342 {

  //  First,greater than 0.
  // Second,only have one '1' bit in their binary notation,so we use x&(x-1) to delete the lowest '1',
  // and if then it becomes 0,it prove that there is only one '1' bit.
  // Third,the only '1' bit should be locate at the odd location,for example,16.It's binary is 00010000.
  // So we can use '0x55555555' to check if the '1' bit is in the right place.
  public boolean isPowerOfFour(int n) {
    return n > 0 && (n&(n-1)) == 0 && (n & 0x55555555) != 0;
  }
}

