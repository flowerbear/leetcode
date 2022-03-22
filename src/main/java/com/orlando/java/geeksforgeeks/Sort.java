package com.orlando.java.geeksforgeeks;

public class Sort {

  public void quickSort(int[] nums) {

    quickSort(nums, 0, nums.length - 1);
  }

  private void quickSort(int[] nums, int left, int right) {

    if (left < right) {
      int pivot = partition(nums, left, right);
      quickSort(nums, left, pivot - 1);
      quickSort(nums, pivot + 1, right);
    }
  }

  private int partition(int[] nums, int left, int right) {
    int p = nums[right];
    int i = left;
    for (int j = left; j < right; j++) {
      if (nums[j] < p) {
        swap(nums, i, j);
        i++;
      }
    }
    swap(nums, i, right);
    return i;
  }

  private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }

  public void mergeSort(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
  }

  private void mergeSort(int[] nums, int left, int right) {
    if (left < right) {
      int m = left + (right - left) / 2;
      quickSort(nums, left, m);
      quickSort(nums, m + 1, right);
      merge(nums, left, m, right);
    }
  }

  private void merge(int[] nums, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] L = new int[n1], R = new int[n2];
    for (int i = 0; i < n1; i++) L[i] = nums[left + i];
    for (int i = 0; i < n2; i++) R[i] = nums[mid + 1 + i];

    int i = 0, j = 0;

    int k = left;

    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        nums[k] = L[i];
        i++;
      } else {
        nums[k] = R[j];
        j++;
      }
      k++;
    }
    while (i < n1) {
      nums[k] = L[i];
      i++; k++;
    }
    while (j < n2) {
      nums[k] = R[j];
      j++; k++;
    }
  }

  public void heapSort(int[] nums) {
    int n = nums.length;
    for (int i = n / 2 - 1; i >=0; i--) {
      heapify(nums, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
      swap(nums, 0, i);
      heapify(nums, i, 0);
    }
  }

  void heapify(int[] nums, int n, int i) {
    int largest = i;
    int l = 2 * i + 1, r = 2 * i + 2;

    if (l < n && nums[l] > nums[largest]) {
      largest = l;
    }
    if (r < n && nums[r] > nums[largest]) {
      largest = r;
    }

    if (largest != i) {
      swap(nums, i, largest);
      heapify(nums, n, largest);
    }
  }
}
