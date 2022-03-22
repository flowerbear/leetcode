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
}
