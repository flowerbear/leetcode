package com.orlando.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution0076 {

  public String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

    Map<Character, Integer> dictT = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      int count = dictT.getOrDefault(t.charAt(i), 0);
      dictT.put(t.charAt(i), count + 1);
    }

    int left = 0, minLeft = 0, minLen = s.length() + 1, count = 0;

    for (int right = 0; right < s.length(); right++) {
      if (dictT.containsKey(s.charAt(right))) {
        dictT.put(s.charAt(right), dictT.get(s.charAt(right)) - 1);
        if (dictT.get(s.charAt(right)) >= 0) count++;
        while (count == t.length()) {
          if (right - left + 1 < minLen) {
            minLeft = left;
            minLen = right - left + 1;
          }
          if (dictT.containsKey(s.charAt(left))) {
            dictT.put(s.charAt(left), dictT.get(s.charAt(left)) + 1);
            if (dictT.get(s.charAt(left)) > 0) count--;
          }
          left++;
        }
      }
    }
    if (minLen > s.length()) return "";
    return s.substring(minLeft, minLeft + minLen);
  }
}
