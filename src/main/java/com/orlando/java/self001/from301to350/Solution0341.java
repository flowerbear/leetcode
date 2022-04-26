package com.orlando.java.self001.from301to350;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Flatten Nested List Iterator
 *
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may
 * also be integers or other lists. Implement an iterator to flatten it.
 *
 * Implement the NestedIterator class:
 *
 *   > NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 *   > int next() Returns the next integer in the nested list.
 *   > boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 *
 * Your code will be tested with the following pseudocode:
 *
 *   initialize iterator with nestedList
 *   res = []
 *   while iterator.hasNext()
 *     append iterator.next() to the end of res
 *   return res
 *
 * If res matches the expected flattened list, then your code will be judged as correct.
 *
 */
public class Solution0341 implements Iterator<Integer>  {

  private interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
  }

  private Queue<Integer> flattenedList;

  public Solution0341(List<NestedInteger> nestedList) {
    flattenedList = new LinkedList<>();
    constructList(nestedList);
  }

  private void constructList(List<NestedInteger> nestedList) {
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) flattenedList.add(ni.getInteger());
      else constructList(ni.getList());
    }
  }

  @Override
  public Integer next() {
    return flattenedList.poll();
  }

  @Override
  public boolean hasNext() {
    return !flattenedList.isEmpty();
  }
}

