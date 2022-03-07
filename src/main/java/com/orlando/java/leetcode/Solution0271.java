package com.orlando.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0271 {

  public String encode(List<String> strs) {

    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str.length() + "/" + str);
    }
    return sb.toString();
  }

  public List<String> decode(String s) {
    List<String> result = new ArrayList<>();

    int endIndex = 0;
    StringBuffer sb = new StringBuffer(s);
    while (sb.length() > 0) {
      int ind = sb.indexOf("/", endIndex);
      int len = Integer.parseInt(sb.substring(endIndex, ind));
      endIndex = endIndex + len + 1;
      String str = sb.substring(ind + 1, endIndex);
      result.add(str);
    }
    return result;
  }
}
