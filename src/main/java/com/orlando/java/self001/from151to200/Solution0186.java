package com.orlando.java.self001.from151to200;

/*
 * Reverse Words in a String II
 *
 * Given an input string , reverse the string word by word.
 *
 */
public class Solution0186 {

  public void reverseWords(char[] s) {
    if (s == null || s.length <= 1) return;

    int i = 0, j = s.length - 1;
    while (i < j) {
      swap(s, i, j);
      i++; j--;
    }

    i = 0; j = 0;
    while (j < s.length) {
      while (j < s.length && s[j] != ' ') {
        j++;
      }
      int m = i, n = j - 1;
      while (m < n) {
        swap(s, m, n);
        m++; n--;
      }
      i = j + 1;
      j = i;
    }
  }

  private void swap(char[] s, int left, int right) {
    char temp = s[left];
    s[left] = s[right];
    s[right] = temp;
  }

  public void reverseWords1(char[] s) {
    int n = s.length;
    for (int i = 0, j = 0; j < n; ++j) {
      if (s[j] == ' ') {
        reverse(s, i, j - 1);
        i = j + 1;
      } else if (j == n - 1) {
        reverse(s, i, j);
      }
    }
    reverse(s, 0, n - 1);
  }

  private void reverse(char[] s, int i, int j) {
    for (; i < j; ++i, --j) {
      char t = s[i];
      s[i] = s[j];
      s[j] = t;
    }
  }
}
