package com.orlando.java.practise;


import java.util.Random;

public class QuickSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        shuffle(nums);
        sort(nums, 0, n - 1);
    }

    private static void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int n = i + random.nextInt(nums.length - i );
            swap(nums, i, n);
        }
    }
    private static void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        sort(nums, left, pivot - 1);
        sort(nums, pivot + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1, j = right;
        while (i <= j) {
            while (i < right && nums[i] <= pivot) i++;
            while (j > left && nums[j] > pivot) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {45, 43, 42, 9, 90, 56, 43, 9, 9, 1, 5, 6, 7, 10, 19, 100};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
}
