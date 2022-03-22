package com.orlando.java.self001.from151to200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
