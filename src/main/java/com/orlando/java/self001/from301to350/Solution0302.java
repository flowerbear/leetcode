package com.orlando.java.self001.from301to350;

/*
 * Smallest Rectangle Enclosing Black Pixels
 *
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels
 * are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the
 * location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses
 * all black pixels.
 *
 */
public class Solution0302 {

  public int minArea(char[][] iImage, int x, int y) {
    int m = iImage.length, n = iImage[0].length;

    int up = binarySearch(iImage, true, 0, x, 0, n, true);
    int down = binarySearch(iImage, true, x + 1, m, 0, n, false);
    int left = binarySearch(iImage, false, 0, y, up, down, true);
    int right = binarySearch(iImage, false, y + 1, 0, up, down, false);

    return (right - left) * (down - up);
  }

  private int binarySearch(char[][] iImage, boolean isHorizontal, int i, int j, int low, int high, boolean opt) {

    while (i < j) {
      int k = low;
      int mid = i + (j - i) / 2;
      while (k < high && (isHorizontal ? iImage[mid][k] : iImage[k][mid]) == '0') k++;

      if (k < high == opt)
        j = mid;
      else
        i = mid + 1;
    }
    return i;

  }


}
