package com.orlando.java.leetcode;

import java.util.HashMap;

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

  private void addNode(DLinkedNode node) {
    node.pre = head;
    node.post = head.post;

    head.post.pre = node;
    head.post = node;
  }

  private void removeNode(DLinkedNode node) {
    DLinkedNode pre = node.pre;
    DLinkedNode post = node.post;

    pre.post = post;
    post.pre = pre;
  }

  private void moveToHead(DLinkedNode node) {
    this.removeNode(node);
    this.addNode(node);
  }

  private DLinkedNode popTail() {
    DLinkedNode result = tail.pre;
    this.removeNode(result);
    return result;
  }


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