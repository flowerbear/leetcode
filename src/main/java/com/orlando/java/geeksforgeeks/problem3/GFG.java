package com.orlando.java.geeksforgeeks.problem3;

import java.nio.Buffer;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * A Simple Fraction
 *
 * Given a fraction. Convert it into a decimal. If the fractional part is repeating, enclose the
 * repeating part in parentheses.
 *
 */
public class GFG {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());

    while (t-- > 0) {
      String[] s = br.readLine().trim().split(" ");
      int n = Integer.parseInt(s[0]);
      int d = Integer.parseInt(s[1]);
      Solution sln = new Solution();
      System.out.println(sln.fractionToDecimal(n, d));
    }
  }
}

class Solution {
  String fractionToDecimal(int numerator, int denominator) {
    StringBuilder sb = new StringBuilder((numerator ^ denominator) < 0 ? "-" : "");
    long a = Math.abs((long) numerator);
    long b = Math.abs((long) denominator);
    sb.append(a / b);

    long reminder = a % b;
    sb.append(reminder != 0 ? "." : "");
    Map<Long, Integer> reminderMap = new HashMap<Long, Integer>();
    int pos = 0;
    while (reminder != 0) {
      sb.append((reminder * 10) / b);
      reminderMap.put(reminder, pos++);
      reminder = (reminder * 10) % b;
      if (reminderMap.containsKey(reminder)) {
        String[] currNum = sb.toString().split("\\.");
        return currNum[0] + "." + currNum[1].substring(0, reminderMap.get(reminder)) + "(" + currNum[1].substring(reminderMap.get(reminder)) + ")";
      }
    }

    if (sb.toString().equals("-0")) {
      return "0";
    }
    return sb.toString();
  }
}