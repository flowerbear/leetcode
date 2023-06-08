package com.orlando.java.self001.from301to350;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Count of Smaller Numbers After Self
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property
 * where counts[i] is the number of smaller elements to the right of nums[i].
 *
 */
public class Solution0315 {
  private class ArrayWithOrigIdx {
    int val;
    int origIdx;

    public ArrayWithOrigIdx(int val, int origIdx) {
      this.val = val;
      this.origIdx = origIdx;
    }
  }


  public List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) return new ArrayList<>();
    int n = nums.length;
    int[] result = new int[n];
    ArrayWithOrigIdx[] newNums = new ArrayWithOrigIdx[n];
    for (int i = 0; i < n; i++) newNums[i] = new ArrayWithOrigIdx(nums[i], i);

    mergeSortAndCount(newNums, 0, n - 1, result);

    List<Integer> resultList = new ArrayList<>();
    for (int i : result) resultList.add(i);
    return resultList;
  }

  private void mergeSortAndCount(ArrayWithOrigIdx[] nums, int start, int end, int[] result) {
    if (start >= end) return;

    int mid = start + (end - start) / 2;
    mergeSortAndCount(nums, start, mid, result);
    mergeSortAndCount(nums, mid + 1, end, result);

    int leftPos = start;
    int rightPos = mid + 1;
    LinkedList<ArrayWithOrigIdx> merged = new LinkedList<>();
    int numElemsRightArrayLessThanLeftArray = 0;
    while (leftPos < mid + 1 && rightPos <= end) {
      if (nums[leftPos].val > nums[rightPos].val) {
        numElemsRightArrayLessThanLeftArray++;
        merged.add(nums[rightPos]);
        rightPos++;
      } else {
        result[nums[leftPos].origIdx] += numElemsRightArrayLessThanLeftArray;
        merged.add(nums[leftPos]);
        leftPos++;
      }
    }

    while (leftPos < mid + 1) {
      result[nums[leftPos].origIdx] += numElemsRightArrayLessThanLeftArray;
      merged.add(nums[leftPos]);
      leftPos++;
    }
    while (rightPos <= end) {
      merged.add(nums[rightPos]);
      rightPos++;
    }

    int pos = start;
    for (ArrayWithOrigIdx m : merged) {
      nums[pos] = m;
      pos++;
    }
  }

  // The basic idea is to do merge sort to nums[]. To record the result, we need to keep the index of each number in
  // the original array. So instead of sort the number in nums, we sort the indexes of each number.
  int[] count;

  public List<Integer> countSmaller1(int[] nums) {
    List<Integer> res = new ArrayList<Integer>();

    count = new int[nums.length];
    int[] indexes = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      indexes[i] = i;
    }
    mergesort(nums, indexes, 0, nums.length - 1);
    for (int i = 0; i < count.length; i++) {
      res.add(count[i]);
    }
    return res;
  }

  private void mergesort(int[] nums, int[] indexes, int start, int end) {
    if (end <= start) {
      return;
    }
    int mid = start + (end - start) / 2;
    mergesort(nums, indexes, start, mid);
    mergesort(nums, indexes, mid + 1, end);

    merge(nums, indexes, start, mid, end);
  }

  private void merge(int[] nums, int[] indexes, int start, int mid, int end) {
    int left_index = start;
    int right_index = mid + 1;
    int rightcount = 0;
    int[] new_indexes = new int[end - start + 1];

    int sort_index = 0;
    while (left_index <= mid && right_index <= end) {
      if (nums[indexes[right_index]] < nums[indexes[left_index]]) {
        new_indexes[sort_index] = indexes[right_index];
        rightcount++;
        right_index++;
      } else {
        new_indexes[sort_index] = indexes[left_index];
        count[indexes[left_index]] += rightcount;
        left_index++;
      }
      sort_index++;
    }
    while (left_index <= mid) {
      new_indexes[sort_index] = indexes[left_index];
      count[indexes[left_index]] += rightcount;
      left_index++;
      sort_index++;
    }
    while (right_index <= end) {
      new_indexes[sort_index++] = indexes[right_index++];
    }
    for (int i = start; i <= end; i++) {
      indexes[i] = new_indexes[i - start];
    }
  }

  private class Pair {
    int val, id;
    Pair(int val, int id) {this.val = val; this.id = id;}
  }

  private Pair[] temp;
  //private int[] count;

  public List<Integer> countSmaller2(int[] nums) {
    int n = nums.length;
    count = new int[n];
    temp = new Pair[n];
    Pair[] arr = new Pair[n];

    for (int i = 0; i < n; i++) {
      arr[i] = new Pair(nums[i], i);
    }

    sort(arr, 0, n - 1);

    List<Integer> res = new LinkedList<>();
    for (int c : count) res.add(c);
    return res;
  }

  private void sort(Pair[] arr, int lo, int hi) {
    if (lo == hi) return;
    int mid = lo + (hi - lo) / 2;
    sort(arr, lo, mid);
    sort(arr, mid + 1, hi);
    merge(arr, lo, mid, hi);
  }

  private void merge(Pair[] arr, int lo, int mid, int hi) {
    for (int i = lo; i <= hi; i++) {
      temp[i] = arr[i];
    }

    int i = lo, j = mid + 1;
    for (int p = lo; p <= hi; p++) {
      if (i == mid + 1) arr[p] = temp[j++];
      else if (j == hi + 1) {
        arr[p] = temp[i++];
        count[arr[p].id] += j - mid - 1;
      } else if (temp[i].val > temp[j].val) arr[p] = temp[j++];
      else {
        arr[p] = temp[i++];
        count[arr[p].id] += j - mid - 1;
      }
    }
  }
}

