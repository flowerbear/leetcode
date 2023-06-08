package com.orlando.java.self001.from701to750;

/*
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
 * target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class Solution0704 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }
        return -1;
    }
}

