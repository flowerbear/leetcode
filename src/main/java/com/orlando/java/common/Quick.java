package com.orlando.java.common;

import java.util.Random;

public class Quick {

    public static void sort(int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private static void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1, j = hi;
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) i++;
            while (j > lo && nums[j] > pivot) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public void quickSort(int[] nums,int low,int high) {
        if (low >= high) return;
        int pi = partition1(nums,low,high);
        //if(low < pi-1) {
            quickSort(nums,low,pi-1);
        //}
        //if(high > pi) {
            quickSort(nums,pi,high);
        //}
    }
    public int partition1(int[] nums,int low,int high) {
        int pivot = nums[low + (high - low)/2];
        while(low <= high) {
            while(nums[low] < pivot) {
                low++;
            }
            while(nums[high] > pivot) {
                high--;
            }
            if(low <= high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }
}
