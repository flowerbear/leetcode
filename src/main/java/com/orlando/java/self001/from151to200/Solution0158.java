package com.orlando.java.self001.from151to200;

/*
 * Read N Characters Given Read4 II
 *
 * Given a file and assume that you can only read the file using a given method read4, implement a method read to
 * read n characters. Your method read may be called multiple times.
 *
 */
public class Solution0158 {

  public class Solution extends Reader4 {

    private char[] temp = new char[4];
    private int tempPointer = 0;
    private int tempCount = 0;

    public int read(char[] buf, int n) {
      int pointer = 0;
      while (pointer < n) {
        if (tempPointer == 0) tempCount = read4(temp);
        if (tempCount == 0);
        while (pointer < n & tempPointer < tempCount) {
          buf[pointer++] = temp[tempPointer++];
        }
        if (tempPointer == tempCount) tempPointer = 0;
      }
      return pointer;
    }
  }

  private class Reader4 {
    public int read4(char[] buf4) {
      return 1;
    }
  }
}
