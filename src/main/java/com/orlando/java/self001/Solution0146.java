package com.orlando.java.self001;

import java.util.HashMap;

/*
 * LRU Cache
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 *   LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 *   int get(int key) Return the value of the key if the key exists, otherwise return -1.
 *   void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair
 *   to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 */
public class Solution0146 {

  private class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
  }

  private int count;
  private int capacity;
  private DLinkedNode head, tail;
  private HashMap<Integer, DLinkedNode> cache = new HashMap<>();

  public Solution0146(int capacity) {
    this.count = 0;
    this.capacity = capacity;
    head = new DLinkedNode();
    head.pre = null;
    tail = new DLinkedNode();
    tail.post = null;
    head.post = tail;
    tail.pre = head;
  }

  public int get(int key) {
    DLinkedNode node = cache.get(key);
    if (node == null) {
      return -1;
    }
    this.moveToHead(node);
    return node.value;
  }

  private void moveToHead(DLinkedNode node) {
    this.removeNode(node);
    this.addNode(node);
  }

  private void removeNode(DLinkedNode node) {
    DLinkedNode pre = node.pre;
    DLinkedNode post = node.post;

    pre.post = post;
    post.pre = pre;
  }

  private void addNode(DLinkedNode node) {
    node.pre = head;
    node.post = head.post;

    head.post.pre = node;
    head.post = node;
  }

  private DLinkedNode popTail() {
    DLinkedNode result = tail.pre;
    this.removeNode(result);
    return result;
  }

  public void put(int key, int value) {
    DLinkedNode node = cache.get(key);
    if (node == null) {
      DLinkedNode newNode = new DLinkedNode();
      newNode.key = key;
      newNode.value = value;
      this.cache.put(key, newNode);
      this.addNode(newNode);
      count++;
      if (count > capacity) {
        DLinkedNode tail = this.popTail();
        this.cache.remove(tail.key);
        count--;
      }
    } else {
      node.value = value;
      this.moveToHead(node);
    }
  }
}
