package com.orlando.java.self001.from401to450;

import java.util.ArrayList;
import java.util.List;

/*
 * Fizz Buzz
 *
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 *   > answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 *   > answer[i] == "Fizz" if i is divisible by 3.
 *   > answer[i] == "Buzz" if i is divisible by 5.
 *   > answer[i] == i (as a string) if none of the above conditions are true.
 *
 */
public class Solution0412 {

  public List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList<>(n);
    for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
      fizz++; buzz++;
      if (fizz == 3 && buzz == 5) {
        result.add("FizzBuzz");
        fizz = 0; buzz = 0;
      } else if (fizz == 3) {
        result.add("Fizz");
        fizz = 0;
      } else if (buzz == 5) {
        result.add("Buzz");
        buzz = 0;
      } else {
        result.add(String.valueOf(i));
      }
    }
    return result;
  }
}

