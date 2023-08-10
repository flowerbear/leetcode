package com.orlando.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0049 {

  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) return new ArrayList<>();
    Map<String, List<String>> result = new HashMap<>();
    for (String s : strs) {
      char[] ca = new char[26];
      for (char c : s.toCharArray()) ca[c - 'a']++;
      String keyStr = String.valueOf(ca);
      if (!result.containsKey(keyStr)) result.put(keyStr, new ArrayList<>());
      result.get(keyStr).add(s);
    }
    return new ArrayList<>(result.values());
  }

  public static void main(String[] args) {
    Solution0049 temp = new Solution0049();
    temp.groupAnagrams(new String[]{"test", "estt", "agtb", "abcd"});
  }
}
