package com.orlando.java.geeksforgeeks;

import java.util.*;
import java.io.*;

public class ArrayChallenge {

    private static final String CHALLENGE_TOKEN = "4eq6vnyt982";

    public static String ArrayChallenge(int[] arr) {
        // code goes here
        StringBuilder sb = new StringBuilder();
        int n = arr.length;
        if (n % 2 != 0) {
            sb.append("-1");
        } else {
            int sum = accumulate(arr, 0, n);
            if (sum % 2 != 0) {
                sb.append("-1");
            } else {
                Arrays.sort(arr);
                int[] halfArray = new int[n / 2];
                if (!search(arr, halfArray, sum, 0, n - 1, 0, n)) sb.append("-1");
                else {
                    for (int num : halfArray) {
                        sb.append(num + ",");
                    }
                    for (int i = 0, j = 0; i < n; i++) {
                        if (j >= n / 2 || arr[i] != halfArray[j]) {
                            sb.append(arr[i] + ",");
                        } else {
                              j++;
                        }
                    }
                    sb.setLength(sb.length() - 1);
                }
            }
        }

        sb.append(CHALLENGE_TOKEN);
        for (int i = 2; i < sb.length(); i += 3) {
            sb.setCharAt(i, 'X');
        }
        return sb.toString();

    }

    private static boolean search(int[] arr, int[] halfArray, int sum, int start, int end, int index, int n) {
        if (index == n / 2) {
            int currSum = accumulate(halfArray, 0, n / 2);
            return currSum == sum / 2;
        }
        for (int i = start; i <= end && end - i + 1 >= n / 2 - index; i++) {
            halfArray[index] = arr[i];
            if (search(arr, halfArray, sum, i + 1, end, index + 1, n)) return true;
        }
        return false;

    }

    private static int accumulate(int[] arr, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res += arr[i];
        }
        return res;
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        System.out.print(ArrayChallenge(new int[]{2, 2, 2, 2, 2, 2, 2, 2}));
    }
}
