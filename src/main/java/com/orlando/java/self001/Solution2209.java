package com.orlando.java.self001;

/*
 * Minimum White Tiles After Covering With Carpets
 *
 * You are given a 0-indexed binary string floor, which represents the colors of tiles on a floor:
 *
 *   > floor[i] = '0' denotes that the ith tile of the floor is colored black.
 *   > On the other hand, floor[i] = '1' denotes that the ith tile of the floor is colored white.
 *
 * You are also given numCarpets and carpetLen. You have numCarpets black carpets, each of length carpetLen tiles.
 * Cover the tiles with the given carpets such that the number of white tiles still visible is minimum. Carpets may
 * overlap one another.
 *
 * Return the minimum number of white tiles still visible.
 *
 */
public class Solution2209 {

  // dp[i][k] means that,
  // using k tiles to cover the first i tiles
  // the minimum number of white tiles still visible.
  //
  // For each tile s[i], we heve two options,
  // One option is doing nothing, jump this tile,
  // jump = dp[i - 1][k] + int(s[i - 1])
  // The other option is covering this tile
  // cover = dp[i - l][k - 1]
  //
  // Then we take the minimum result of two options:
  // dp[i][k] = min(jump, cover)
  //
  // Finally after explore all combination of (i,k),
  // we return dp[n][nc].
  public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
    int n = floor.length(), dp[][] = new int[n + 1][numCarpets + 1];
    for (int i = 1; i <= n; i++) {
      for (int k = 0; k <= numCarpets; k++) {
        int jump = dp[i - 1][k] + floor.charAt(i - 1) - '0';
        int cover = k > 0 ? dp[Math.max(i - carpetLen, 0)][k - 1] : 1000;
        dp[i][k] = Math.min(cover, jump);
      }
    }
    return dp[n][numCarpets];
  }
}
