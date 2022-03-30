package com.orlando.java.self001.from201to250;

import java.util.ArrayList;
import java.util.List;

/*
 * Majority Element II
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 */
public class Solution0229 {

  // Boyer-Moore Majority Vote Algorithm
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums.length == 0) return result;

    int num1 = nums[0], num2 = nums[0], cnt1 = 0, cnt2 = 0;
    for (int n : nums) {
      if (n == num1)
        cnt1++;
      else if (n == num2)
        cnt2++;
      else if (cnt1 == 0) {
        num1 = n;
        cnt1++;
      } else if (cnt2 == 0) {
        num2 = n;
        cnt2++;
      } else {
        cnt1--; cnt2--;
      }
    }
    cnt1 = 0; cnt2 = 0;
    for (int n : nums) {
      if (n == num1) cnt1++;
      else if (n == num2) cnt2++;
    }

    if (cnt1 > nums.length / 3)
      result.add(num1);
    if (cnt2 > nums.length / 3)
      result.add(num2);
    return result;
  }
}
