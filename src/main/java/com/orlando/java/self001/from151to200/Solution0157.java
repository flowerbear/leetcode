package com.orlando.java.self001.from151to200;

/*
 * Read N Characters Given Read4
 *
 * Given a file and assume that you can only read the file using a given method read4, implement a method to
 * read n characters.
 *
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters
 * left in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *
 * Note: The read function will only be called once for each test case.
 *
 */
public class Solution0157 {

  public class Solution extends Reader4 {

    public int read(char[] buf, int n) {
      char[] temp = new char[4];
      int total = 0;

      while (true) {
        int read = Math.min(n - total, read4(temp));
        if (read == 0) break;
        for (int i = 0; i < read; i++) {
          buf[total +i] = temp[i];
        }
        total += read;
      }
      return total;
    }
  }

  private class Reader4 {
    public int read4(char[] buf4) {
      return 1;
    }
  }
}
