package com.orlando.java.self001;

import java.util.ArrayList;
import java.util.List;

/*
 * Restore IP Addresses
 *
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0
 * and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312"
 * and "192.168@1.1" are invalid IP addresses.
 *
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting
 * dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses
 * in any order.
 *
 */
public class Solution0093 {

  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    int len = s.length();

    StringBuilder ip = new StringBuilder();

    for (int a = 1; a <= 3; a++)
      for (int b = 1; b <= 3; b++)
        for (int c = 1; c <= 3; c++) {
          int d = len - a - b - c;
          if (d > 0 & d <= 3) {
            int A = Integer.parseInt(s.substring(0, a));
            int B = Integer.parseInt(s.substring(a, a + b));
            int C = Integer.parseInt(s.substring(a + b, a + b +c));
            int D = Integer.parseInt(s.substring(a + b + c));
            if (A <= 255 && B <=255 && C <= 255 && D <= 255) {
              ip.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
              if (ip.length() == len + 3) {
                result.add(ip.toString());
              }
              ip.setLength(0);
            }
          }
        }
    return result;
  }
}
