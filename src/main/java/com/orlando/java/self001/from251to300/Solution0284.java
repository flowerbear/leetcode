package com.orlando.java.self001.from251to300;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Peeking Iterator
 *
 * Design an iterator that supports the peek operation on an existing iterator in addition to the hasNext and the next
 * operations.
 *
 * Implement the PeekingIterator class:
 *
 *   > PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator iterator.
 *   > int next() Returns the next element in the array and moves the pointer to the next element.
 *   > boolean hasNext() Returns true if there are still elements in the array.
 *   > int peek() Returns the next element in the array without moving the pointer.
 *
 * Note: Each language may have a different implementation of the constructor and Iterator, but they all support
 * the int next() and boolean hasNext() functions.
 *
 */
public class Solution0284 implements Iterator<Integer> {

  private Integer next = null;
  private Iterator<Integer> iter;
  boolean noSuchElement;

  public Solution0284(Iterator<Integer> iterator) {
    // initialize any member here.
    iter = iterator;
    if (iter.hasNext()) next = iter.next();
    else noSuchElement = true;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return next;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    if (noSuchElement) throw new NoSuchElementException();
    Integer result = next;
    if (iter.hasNext()) next = iter.next();
    else noSuchElement = true;
    return result;
  }

  @Override
  public boolean hasNext() {
    return !noSuchElement;
  }
}
