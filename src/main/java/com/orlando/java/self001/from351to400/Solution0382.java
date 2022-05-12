package com.orlando.java.self001.from351to400;

import com.orlando.java.common.ListNode;

import java.util.Random;

/*
 * Linked List Random Node
 *
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same
 * probability of being chosen.
 *
 * Implement the Solution class:
 *
 *   > Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
 *   > int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should
 *     be equally likely to be chosen.
 *
 */
public class Solution0382 {

  public class Solution {

    ListNode head;
    Random rand;

    public Solution(ListNode head) {
      this.head = head;
      rand = new Random();
    }

    public int getRandom() {
      ListNode c = this.head;
      int r = c.val;
      for (int i = 1; c.next != null; i++) {
        c = c.next;
        if (rand.nextInt(i + 1) == i) r = c.val;
      }
      return r;
    }
  }
}

