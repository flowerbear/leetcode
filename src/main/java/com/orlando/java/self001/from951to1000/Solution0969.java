package com.orlando.java.self001.from951to1000;

import java.util.ArrayList;
import java.util.List;

public class Solution0969 {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = arr.length; i > 0; i--) {
            int j = 0;
            for (; arr[j] != i; j++);
            reverse(arr, j);
            res.add(j + 1);
            reverse(arr, i - 1);
            res.add(i);
        }
        return res;
    }

    private void reverse(int[] nums, int k) {
        for (int i = 0, j = k; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
