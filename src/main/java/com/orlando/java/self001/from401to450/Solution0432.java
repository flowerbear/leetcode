package com.orlando.java.self001.from401to450;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/*
 * All O`one Data Structure
 *
 * Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum
 * counts.
 *
 * Implement the AllOne class:
 *
 *   > AllOne() Initializes the object of the data structure.
 *   > inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure,
 *     insert it with count 1.
 *   > dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement,
 *     remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
 *   > getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
 *   > getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
 *
 * Note that each function must run in O(1) average time complexity.
 *
 */
public class Solution0432 {

  class AllOne {

    class ValueNode {
      ValueNode prev, next;
      int val;
      Set<String> strs;
      ValueNode(int v) {
        val = v;
        strs = new LinkedHashSet<>();
      }

      void insertAt(ValueNode node) {
        next = node;
        prev = node.prev;
        next.prev = this;
        prev.next = this;
      }

      void remove(String str) {
        strs.remove(str);
        if (strs.isEmpty()) {
          prev.next = next;
          next.prev = prev;
        }
      }
    }

    ValueNode head, tail;
    Map<String, ValueNode> keys;

    public AllOne() {
      head = new ValueNode(0);
      tail = new ValueNode(0);
      head.next = tail;
      tail.prev = head;
      keys = new HashMap<>();
    }

    public void inc(String key) {
      ValueNode node = keys.getOrDefault(key, head);
      ValueNode vn = node.next;
      if (vn.val != node.val + 1) {
        vn = new ValueNode(node.val + 1);
        vn.insertAt(node.next);
      }
      vn.strs.add(key);
      keys.put(key, vn);
      if (node != head) node.remove(key);
    }

    public void dec(String key) {
      ValueNode node = keys.get(key);
      if (node == null) return;
      if (node.val == 1) {
        keys.remove(key);
        node.remove(key);
        return;
      }
      ValueNode vn = node.prev;
      if (vn.val != node.val - 1) {
        vn = new ValueNode(node.val - 1);
        vn.insertAt(node);
      }
      vn.strs.add(key);
      keys.put(key, vn);
      node.remove(key);
    }

    public String getMaxKey() {
      if (tail.prev == head) return "";
      return tail.prev.strs.iterator().next();
    }

    public String getMinKey() {
      if (head.next == tail) return "";
      return head.next.strs.iterator().next();
    }
  }

}

