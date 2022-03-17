package com.orlando.java.self001;

/*
 * Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 *   MinStack() initializes the stack object.
 *   void push(int val) pushes the element val onto the stack.
 *   void pop() removes the element on the top of the stack.
 *   int top() gets the top element of the stack.
 *   int getMin() retrieves the minimum element in the stack.
 *
 */
public class Solution0155 {
  private class Node {
    int val;
    int min;
    Node next;

    private Node(int val, int min, Node next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }
  }

  private Node head;

  public Solution0155() {
  }

  public void push(int val) {
    if (head == null) {
      head = new Node(val, val, null);
    } else {
      head = new Node(val, Math.min(val, head.min), head);
    }
  }

  public void pop() {
    head = head.next;
  }

  public int top() {
    return head.val;
  }

  public int getMin() {
    return head.min;
  }
}
