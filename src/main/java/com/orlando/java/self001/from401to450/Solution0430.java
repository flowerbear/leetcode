package com.orlando.java.self001.from401to450;

/*
 * Flatten a Multilevel Doubly Linked List
 *
 * You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an
 * additional child pointer. This child pointer may or may not point to a separate doubly linked list, also
 * containing these special nodes. These child lists may have one or more children of their own, and so on,
 * to produce a multilevel data structure as shown in the example below.
 *
 * Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level,
 * doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr
 * and before curr.next in the flattened list.
 *
 * Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 *
 */
public class Solution0430 {

  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
  }

  public Node flatten(Node head) {
    if (head == null) return head;

    Node p = head;
    while (p != null) {
      if (p.child == null) {
        p = p.next;
        continue;
      }

      Node temp = p.child;
      while (temp.next != null) temp = temp.next;
      temp.next = p.next;

      if (p.next != null) p.next.prev = temp;

      p.next = p.child;
      p.child.prev = p;
      p.child = null;
    }

    return head;
  }
}

