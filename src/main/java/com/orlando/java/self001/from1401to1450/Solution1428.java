package com.orlando.java.self001.from1401to1450;

import java.util.List;

public class Solution1428 {

    interface BinaryMatrix {
        public int get(int row, int col);
        public List<Integer> dimensions();
    }
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0), columns = dimensions.get(1);
        int leftMostColumn = columns;
        for (int i = 0; i < rows; i++) {
            int low = 0, high = leftMostColumn - 1;
            if (binaryMatrix.get(i, high) == 0)
                continue;
            leftMostColumn = Math.min(leftMostColumn, high);
            while (low < high) {
                int mid = (high - low) / 2 + low;
                int num = binaryMatrix.get(i, mid);
                if (num == 1) {
                    high = mid;
                    leftMostColumn = Math.min(leftMostColumn, mid);
                } else
                    low = mid + 1;
            }
            if (leftMostColumn == 0)
                break;
        }
        return leftMostColumn == columns ? -1 : leftMostColumn;
    }

    public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        List<Integer> scale = binaryMatrix.dimensions();
        int rows = scale.get(0), cols = scale.get(1);
        int res = -1;
        for (int row = 0; row < rows; ++row) {
            int left = 0, right = cols - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (binaryMatrix.get(row, mid) == 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (binaryMatrix.get(row, left) == 1) {
                if (res == -1) {
                    res = left;
                } else {
                    res = Math.min(res, left);
                }
            }
        }
        return res;
    }

}
