package com.orlando.java.self001;

/*
 * Implement strStr()
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 */
public class Solution0028 {

  public int strStr(String haystack, String needle) {
    for (int i = 0; ; i++)
      for (int j = 0; ; j++) {
        if (j == needle.length()) return i;
        if (i + j == haystack.length()) return -1;
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      }
  }

  public int strStrKMP(String haystack, String needle) {
    int m = haystack.length(), n = needle.length();
    if (n == 0) return 0;

    int[] lps = kmpProcess(needle);
    for (int i = 0, j = 0; i < m;) {
      if (haystack.charAt(i) == needle.charAt(j)) {
        i++; j++;
      }
      if (j == n) return i - j; // j = lps[j - 1]
      if (i < m && haystack.charAt(i) != needle.charAt(j)) {
        if (j != 0) j = lps[j - 1];
        else i++;
      }
    }
    return -1;
  }

  private int[] kmpProcess(String str) {
    int n = str.length();
    int[] lps = new int[n];
    for (int i = 1, len = 0; i < n;) {
      if (str.charAt(i) == str.charAt(len)) {
        lps[i++] = ++len;
      } else if (len != 0) {
        len = lps[len - 1];
      } else {
        lps[i++] = 0;
      }
    }
    return lps;
  }
}
