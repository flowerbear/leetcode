package com.orlando.java.self001;

/*
 * Zigzag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P A H N
 * APLSIIG
 * Y I R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows
 *
 */
public class Solution0006 {

  // bucketSize = 2 * numRows - 2
  // i loop numRows; j += bucketSize
  // Mid rows: j + bucketSize - i
  public String convert(String s, int numRows) {

    if (numRows <= 1) return s;
    int bucketSize = 2 * numRows - 2, n = s.length();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j + i < n; j += bucketSize) {
        sb.append(s.charAt(i + j));
        if (i != 0 && i != numRows - 1 && j + bucketSize - i < n) {
          sb.append(s.charAt(j + bucketSize - i));
        }
      }
    }
    return sb.toString();
  }
}
