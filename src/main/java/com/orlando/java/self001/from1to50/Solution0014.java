package com.orlando.java.self001.from1to50;

/*
 * Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 */
public class Solution0014 {

  // prefix = strs[0]; strs[i].indexOf(prefix);
  public String longestCommonPrefix(String[] strs) {

    if (strs == null || strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) return "";
      }
    }
    return prefix;
  }

  public String longestCommonPrefix1(String[] strs) {
    if (strs == null || strs.length == 0) return "";

    for (int i = 0; i < strs[0].length(); i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != c) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }

  // Binary Search
  public String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) return null;
    int minLen = Integer.MAX_VALUE;
    for (String str : strs) {
      minLen = Math.min(minLen, str.length());
    }
    int i = 1, j = minLen;
    while (i <= j) {
      int mid = (i + j) / 2;
      if (isCommonPrefix(strs, mid)) {
        i = mid + 1;
      } else {
        j = mid - 1;
      }
    }
    return strs[0].substring(0, (i + j) / 2);
  }

  private boolean isCommonPrefix(String[] strs, int len) {
    String str = strs[0].substring(0, len);
    for (int i = 1; i < strs.length; i++) {
      if (!strs[i].startsWith(str)) return false;
    }
    return true;
  }
}
