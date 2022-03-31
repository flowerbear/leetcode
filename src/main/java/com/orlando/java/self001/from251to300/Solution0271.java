package com.orlando.java.self001.from251to300;

import java.util.ArrayList;
import java.util.List;

/*
 * Encode and Decode Strings
 *
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and
 * is decoded back to the original list of strings.
 *
 */
public class Solution0271 {

  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      sb.append(s.length() + "/" + s);
    }
    return sb.toString();
  }

  public List<String> decode(String s) {
    List<String> result = new ArrayList<>();

    int endIndex = 0;
    StringBuilder sb = new StringBuilder(s);
    while (sb.length() > 0) {
      int index = sb.indexOf("/", endIndex);
      int len = Integer.parseInt(sb.substring(endIndex, index));
      endIndex = endIndex + len + 1;
      String str = sb.substring(index + 1, endIndex);
      result.add(str);
    }
    return result;
  }
}
