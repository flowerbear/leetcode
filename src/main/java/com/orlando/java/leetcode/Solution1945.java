package com.orlando.java.leetcode;

public class Solution1945 {

  public int getLucky(String s, int k) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      int val = c - 'a' + 1;
      sb.append(val);
    }
    int sum = 0;
    String str = sb.toString();
    for (int i = 0; i < k; i++) {
      sum = 0;
      for (char c : str.toCharArray()) {
        sum += (c - '0');
      }
      str = String.valueOf(sum);
    }
    return sum;
  }

  public int getLucky2(String s, int k) {
    int result = 0;
    for (char c : s.toCharArray()) {
      int val = c - 'a' + 1;
      result += val / 10;
      result += val % 10;
    }
    int kk = k;
    while (--kk > 0) {
      int tmp = 0;
      while (result > 0) {
        tmp += result % 10;
        result = result / 10;
      }
      result = tmp;
    }
    return result;
  }
}
