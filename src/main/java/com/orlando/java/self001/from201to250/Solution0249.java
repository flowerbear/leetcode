package com.orlando.java.self001.from201to250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Group Shifted Strings
 *
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 * We can keep "shifting" which forms the sequence:
 *
 *  > "abc" -> "bcd" -> ... -> "xyz"
 *
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the
 * same shifting sequence.
 *
 */
public class Solution0249 {

  public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> result = new ArrayList<>();

    Map<String, List<String>> map = new HashMap<>();

    for (String str : strings) {
      String key = findKey(str);
      List<String> temp = map.getOrDefault(key, new ArrayList<String>());
      temp.add(str);
      map.put(key, temp);
    }
    result.addAll(map.values());
    return result;
  }

  private String findKey(String str) {
    if (str.length() == 0) return "";
    StringBuilder sb = new StringBuilder();
    int distance = str.charAt(0) - 'a';
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      char offset = (char) (c - distance);
      if (offset < 'a') {
        offset = (char) (offset + 26);
      }
      sb.append(offset);
    }
    return sb.toString();
  }
}
