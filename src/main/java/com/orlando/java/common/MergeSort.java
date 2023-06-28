package com.orlando.java.common;

import java.util.Arrays;

public class MergeSort {

    private int[] temp;
    public void sort(int arr[]) {
        temp = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int l, int r) {
        if (l == r) return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        for (int i = l; i <= r; i++) temp[i] = arr[i];
        int left = l, right = mid + 1;
        for (int p = l; p <= r; p++) {
            if (left == mid + 1) arr[p] = temp[right++];
            else if (right == r + 1) arr[p] = temp[left++];
            else if (temp[left] > temp[right]) arr[p] = temp[right++];
            else arr[p] = temp[left++];
        }
    }

    public static void main(String[] args) {
        MergeSort temp = new MergeSort();
        int[] arr = new int[]{10, 9, 1, 2, 7, 5, 3, 19, 13, 18};
        temp.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
