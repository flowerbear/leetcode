package com.orlando.java.leetcode;

public class Solution0421 {

  public int findMaximumXOR(int[] nums) {
    if (nums.length == 1) {
      return 0;
    } else if (nums.length == 2) {
      return nums[0] ^ nums[1];
    }

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

          if (node.child[bit] == null) {
            node.child[bit] = new TrieNode();
          }

          node = node.child[bit];
        }
      }
    }
  }

  class TrieNode {
    TrieNode[] child = new TrieNode[2];
  }

  public static void main(String[] args) {

  }
}
