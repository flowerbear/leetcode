package com.orlando.java.leetcode;

public class Solution1946 {

  public String maximumNumber(String num, int[] change) {
    char[] chars = num.toCharArray();
    boolean changed = false;
    for (int i = 0; i < chars.length; i++) {
      int cur = chars[i] - '0';
      int candidate = change[cur];
      if (candidate > cur) {
        chars[i] = (char) (candidate + '0');
        changed = true;
      }
      if ((candidate < cur) & changed) {
        break;
      }
    }
    return new String(chars);
  }

  public String maximumNumber1(String num, int[] change) {
    StringBuilder sb =  new StringBuilder(num);
    boolean modificationStarted =false;
    for(int i=0;i<sb.length();i++){
      int idx = sb.charAt(i)-'0';
      if( idx > change[idx] && modificationStarted)
        break;
      else if(idx < change[idx]){
        sb.setCharAt(i, (char)('0'+change[idx]));
        modificationStarted = true;
      }
    }
    return sb.toString();
  }
}
