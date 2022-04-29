package com.orlando.java.self001.from351to400;

/*
 * Sort Transformed Array
 *
 * Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form
 * f(x) = ax2 + bx + c to each element x in the array.
 *
 * The returned array must be in sorted order.
 *
 * Expected time complexity: O(n)
 *
 */
public class Solution0360 {


  private int calculate(int x, int a, int b, int c) {
    return a * x * x + b * x + c;
  }

  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int[] result = new int[nums.length];
    int i = 0, j = nums.length - 1;
    int index;

    if (a > 0) {
      index = nums.length - 1;
      while (i <= j) {
        int iResult = calculate(nums[i], a, b, c), jResult = calculate(nums[j], a, b, c);
        result[index--] = iResult > jResult ? iResult : jResult;
        if (iResult > jResult) i++;
        else j--;
      }
    } else {
      index = 0;
      while (i <= j) {
        int iResult = calculate(nums[i], a, b, c), jResult = calculate(nums[j], a, b, c);
        result[index++] = iResult < jResult ? iResult : jResult;
        if (iResult < jResult) i++;
        else j--;
      }
    }
    return result;
  }
}

