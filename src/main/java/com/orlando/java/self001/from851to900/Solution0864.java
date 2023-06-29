package com.orlando.java.self001.from851to900;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution0864 {


    class State {
        int keys, i, j;

        State(int keys, int i, int j) {
            this.keys = keys;
            this.i = i;
            this.j = j;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max = -1;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                } else if (c >= 'a' && c <= 'f') {
                    max = Math.max(c - 'a' + 1, max);
                }
            }
        }
        State start = new State(0, x, y);
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + x + " " + y);
        q.offer(start);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                State cur = q.poll();
                if (cur.keys == (1 << max) - 1) return step;

                for (int[] dir : dirs) {
                    int i = cur.i + dir[0], j = cur.j + dir[1];
                    int keys = cur.keys;
                    if (i >= 0 && j >= 0 && i < m && j < n) {
                        char c = grid[i].charAt(j);
                        if (c == '#') continue;
                        else if (c >= 'a' && c <= 'f') keys |= 1 << (c - 'a');
                        else if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) continue;
                        if (!visited.contains(keys + " " + i + " " + j)) {
                            visited.add(keys + " " + i + " " + j);
                            q.offer(new State(keys, i, j));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}

