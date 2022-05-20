package com.orlando.java.self001.from451to500;

import java.util.Arrays;

/*
 * Assign Cookies
 *
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at
 * most one cookie.
 *
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i
 * will be content. Your goal is to maximize the number of your content children and output the maximum number.
 *
 */
public class Solution0455 {

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g); Arrays.sort(s);
    int child = 0, cookie = 0;
    while (child < g.length && cookie < s.length) {
      if (g[child] <= s[cookie]) child++;
      cookie++;
    }
    return child;
  }
}

