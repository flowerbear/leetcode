package com.orlando.java.self001.from351to400;

import com.orlando.java.common.NestedInteger;

import java.util.List;
import java.util.Stack;

/*
 * Mini Parser
 *
 * Given a string s represents the serialization of a nested list, implement a parser to deserialize it and return
 * the deserialized NestedInteger.
 *
 * Each element is either an integer or a list whose elements may also be integers or other lists.
 *
 */
public class Solution0385 {

  public class NestedIntegerClass implements NestedInteger {
    public NestedIntegerClass() {};

    public NestedIntegerClass(int value) {};

    @Override
    public boolean isInteger() {
      return false;
    }

    @Override
    public Integer getInteger() {
      return null;
    }

    @Override
    public List<NestedInteger> getList() {
      return null;
    }

    @Override
    public void add(NestedInteger ni) {

    }

    @Override
    public void setInteger(int value) {

    }

  }

  public NestedInteger deserialize(String s) {
    if (s.isEmpty()) return null;
    if (s.charAt(0) != '[') return new NestedIntegerClass(Integer.valueOf(s));

    Stack<NestedInteger> stack = new Stack<>();
    NestedInteger curr = null;
    int l = 0;

    for (int r = 0; r < s.length(); r++) {
      char ch = s.charAt(r);
      if (ch == '[') {
        if (curr != null) stack.push(curr);
        curr = new NestedIntegerClass();
        l = r + 1;
      } else if (ch == ']') {
        String num = s.substring(l, r);
        if (!num.isEmpty()) {
          curr.add(new NestedIntegerClass(Integer.valueOf(num)));
        }
        if (!stack.isEmpty()) {
          NestedInteger pop = stack.pop();
          pop.add(curr);
          curr = pop;
        }
        l = r + 1;
      } else if (ch == ',') {
        if (s.charAt(r - 1) != ']') {
          String num = s.substring(l, r);
          curr.add(new NestedIntegerClass(Integer.valueOf(num)));
        }
        l = r + 1;
      }
    }
    return curr;
  }
}

