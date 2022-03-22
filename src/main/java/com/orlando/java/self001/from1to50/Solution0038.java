package com.orlando.java.self001.from1to50;

/*
 * Count and Say
 *
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a
 * different digit string.
 *
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a
 * contiguous section all of the same character. Then for each group, say the number of characters, then say the
 * character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 *
 */
public class Solution0038 {

  public String countAndSay(int n) {
    String s = "1";
    for (int i = 1; i < n; i++) {
      s = countIds(s);
    }
    return s;
  }

  private String countIds(String s) {
    StringBuilder sb = new StringBuilder();
    char c = s.charAt(0);
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == c) count++;
      else {
        sb.append(count);
        sb.append(c);
        c = s.charAt(i);
        count = 1;
      }
    }
    sb.append(count);
    sb.append(c);
    return sb.toString();
  }
}
