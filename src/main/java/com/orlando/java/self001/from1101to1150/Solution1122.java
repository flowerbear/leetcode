package com.orlando.java.self001.from1101to1150;

public class Solution1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int num : arr1) count[num]++;
        int i = 0;
        for (int num : arr2) while (count[num]-- > 0) arr1[i++] = num;
        for (int n = 0; n < count.length; n++) while (count[n]-- > 0) arr1[i++] = n;
        return arr1;
    }
}
