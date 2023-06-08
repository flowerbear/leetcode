package com.orlando.java.self001.from151to200;

import java.util.*;

/*
 * Repeated DNA Sequences
 *
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *
 * For example, "ACGAATTCCG" is a DNA sequence.
 *
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule. You may return the answer in any order.
 *
 */
public class Solution0187 {

  public List<String> findRepeatedDnaSequences(String s) {
    Set seen = new HashSet(), repeated = new HashSet();

    for (int i = 0; i + 9 < s.length(); i++) {
      String ten = s.substring(i, i + 10);
      if (!seen.add(ten)) repeated.add(ten);
    }

    return new ArrayList<>(repeated);
  }

  public List<String> findRepeatedDnaSequences1(String s) {
    int[] nums = new int[s.length()];
    int i = 0;
    for (Character c : s.toCharArray()) {
      switch (c) {
        case 'A':
          nums[i] = 0;
          break;
        case 'G':
          nums[i] = 1;
          break;
        case 'C':
          nums[i] = 2;
          break;
        case 'T':
          nums[i] = 3;
          break;
      }
      i++;
    }

    Set<Integer> seen = new HashSet<>();
    Set<String> res = new HashSet<>();

    int L = 10, R = 4, RL = (int) Math.pow(R, L - 1), windowHash = 0;

    int left = 0, right = 0;

    while (right < nums.length) {
      windowHash = R * windowHash + nums[right];
      right++;

      if (right - left == L) {
        if (seen.contains(windowHash)) res.add(s.substring(left, right));
        else seen.add(windowHash);
        windowHash = windowHash - nums[left] * RL;
        left++;
      }

    }
    return new LinkedList<>(res);
  }

  public static void main(String[] args) {
    Solution0187 temp = new Solution0187();
    List<String> result = temp.findRepeatedDnaSequences1("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
  }
}
