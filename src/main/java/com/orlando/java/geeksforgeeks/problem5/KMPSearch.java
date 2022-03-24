package com.orlando.java.geeksforgeeks.problem5;

import java.util.ArrayList;
import java.util.List;

public class KMPSearch {

  private int[] KMPProcess(String p) {
    int[] lps = new int[p.length()];

    for (int i = 1, len = 0; i < p.length();) {
      if (p.charAt(i) == p.charAt(len)) {
        lps[i++] = ++len;
      } else if (len != 0) {
        len = lps[len - 1];
      } else {
        lps[i++] = 0; // or lps[i++] = len
      }
    }
    return lps;
  }

  public List<Integer> search(String s, String p) {
    List<Integer> result = new ArrayList<>();
    int m = p.length(), n = s.length();
    int[] lps = KMPProcess(p);

    for (int i = 0, j = 0; i < n;) {
      if (s.charAt(i) ==p.charAt(j)) {
        i++; j++;
      }
      if (j == m) {
        result.add(i - j);
        j = lps[j - 1];
      } else if (i < n && s.charAt(i) != p.charAt(j)) {
        if (j != 0) j = lps[j - 1];
        else i++;
      }
    }
    return result;
  }
}
