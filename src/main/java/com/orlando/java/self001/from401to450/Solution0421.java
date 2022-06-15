package com.orlando.java.self001.from401to450;

import java.util.HashSet;
import java.util.Set;

/*
 * Maximum XOR of Two Numbers in an Array
 *
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
 *
 */
public class Solution0421 {

  class TrieNode {
    TrieNode[] child = new TrieNode[2];
  }

  class Trie {
    TrieNode root;
    Trie() {
      this.root = new TrieNode();
    }
    public void insert(int[] nums) {
      for (int num : nums) {
        TrieNode node = this.root;
        for (int i = 31; i >= 0; i--) {
          int bit = (num >>> i) & 1;
          if (node.child[bit] == null) node.child[bit] = new TrieNode();
          node = node.child[bit];
        }
      }
    }
  }

  public int findMaximumXOR(int[] nums) {
    if (nums.length == 1) return 0;
    else if (nums.length == 2) return nums[0] ^ nums[1];

    Trie trie = new Trie();
    trie.insert(nums);

    int max = 0;
    for (int num : nums) {
      TrieNode node = trie.root;
      int res = 0;
      for (int i = 31; i >= 0; i--) {
        int targetBit = 1 - ((num >>> i) & 1);
        if (node.child[targetBit] != null) {
          res |= 1 << i;
          node = node.child[targetBit];
        } else {
          node = node.child[1 - targetBit];
        }
      }
      max = Math.max(max, res);
    }
    return max;
  }

  public int findMaximumXOR1(int[] nums) {
    int max = 0, mask = 0;
    for (int i = 31; i >= 0; i--) {
      mask |= (1 << i);
      Set<Integer> set = new HashSet<>();
      int target = max | (1 << i);
      for (int num : nums) {
        int leftPart = num & mask;
        if (set.contains(leftPart ^ target)) {
          max = target;
          break;
        }
        set.add(leftPart);
      }
    }
    return max;
  }
}

