package com.orlando.java.self001.from151to200;

import java.util.Locale;

/*
 * Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string
 * should only have a single space separating the words. Do not include any extra spaces.
 *
 */
public class Solution0151 {

  public String reverseWords(String s) {
    if (s == null || s.length() == 0) return null;

    char[] a = s.toCharArray();
    int n = a.length;

    // reverse the whole string
    reverse(a, 0, n - 1);
    // reverse each word
    reverseWords(a, n);
    return cleanSpace(a, n);
  }

  private String cleanSpace(char[] a, int n) {
    int i = 0, j = 0;
    while (j < n) {
      while (j < n && a[j] == ' ') j++;
      while (j < n && a[j] != ' ') a[i++] = a[j++];
      while (j < n && a[j] == ' ') j++;
      if (j < n) a[i++] = ' ';
    }

    return new String(a).substring(0, i);
  }

  private void reverseWords(char[] a, int n) {
    int i = 0, j = 0;
    while (i < n) {
      while (i < j || i < n && a[i] == ' ') i++;
      while (j < i || j < n && a[j] != ' ') j++;
      reverse(a, i, j - 1);
    }
  }

  private void reverse(char[] a, int left, int right) {
    while (left < right) {
      char t = a[left];
      a[left++] = a[right];
      a[right--] = t;
    }
  }
}
