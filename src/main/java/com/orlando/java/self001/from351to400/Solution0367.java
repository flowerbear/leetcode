package com.orlando.java.self001.from351to400;

/*
 * Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 */
public class Solution0367 {

  public boolean isPerfectSquare(int num) {
    long i = 1, temp = 1;
    while (temp < num) {
      i += 2;
      temp += i;
    }
    return temp == num;
  }
}

