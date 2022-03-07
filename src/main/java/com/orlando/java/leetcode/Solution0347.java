package com.orlando.java.leetcode;

import java.util.*;

public class Solution0347 {

  public int[] topKFrequent(int[] nums, int k) {
    if (k == nums.length) return nums;

    Map<Integer, Integer> count = new HashMap<>();
    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
    for (int n : count.keySet()) {
      heap.add(n);
      if (heap.size() > k) heap.poll();
    }

    int[] top = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      top[i] = heap.poll();
    }
    return top;
  }

  int[] unique;
  Map<Integer, Integer> count;

  private void swap(int a, int b) {
    int tmp = unique[a];
    unique[a] = unique[b];
    unique[b] = tmp;
  }

  private int partition(int left, int right, int pivot_index) {
    int pivot_freq = count.get(unique[pivot_index]);
    swap(pivot_index, right);
    int store_index = left;

    for (int i = left; i <= right; i++) {
      if (count.get(unique[i]) < pivot_freq) {
        swap(store_index, i);
        store_index++;
      }
    }
    swap(store_index, right);
    return store_index;
  }

  private void quickSelect(int left, int right, int k_smallest) {
    if (left == right) return;

    Random rNum = new Random();
    int pivot_index = left + rNum.nextInt(right - left);

    pivot_index = partition(left, right, pivot_index);

    if (k_smallest == pivot_index) return;
    else if (k_smallest < pivot_index) quickSelect(left, pivot_index - 1, k_smallest);
    else quickSelect(pivot_index + 1, right, k_smallest);
  }

  public int[] topKFrequent1(int[] nums, int k) {
    count = new HashMap<>();
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    int n = count.size();
    unique = new int[n];
    int i = 0;
    for (int num : count.keySet()) {
      unique[i] = num;
      i++;
    }

    quickSelect(0, n - 1, n - k);
    return Arrays.copyOfRange(unique, n - k, n);
  }

  public int[] topKFrequent2(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0) return new int[0];
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

    List<Integer>[] buckets = new ArrayList[nums.length + 1];
    for (int key : freqMap.keySet()) {
      if (buckets[freqMap.get(key)] == null) buckets[freqMap.get(key)] = new ArrayList<>();
      buckets[freqMap.get(key)].add(key);
    }

    int[] result = new int[Math.min(freqMap.size(), k)];
    int redIdx = 0;
    for (int i = buckets.length - 1; i >=0; i--) {
      if (buckets[i] == null) continue;
      for (int num : buckets[i]) {
        result[redIdx++] = num;
        if (redIdx == result.length) return result;
      }
    }
    return result;
  }
}
