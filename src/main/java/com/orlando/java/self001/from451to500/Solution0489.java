package com.orlando.java.self001.from451to500;

import java.util.HashSet;
import java.util.Set;

public class Solution0489 {

    interface Robot {
        public boolean move();
        public void turnLeft();
        public void turnRight();
        public void clean();
    }
    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0, new HashSet<>());
    }
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private void dfs(Robot robot, int d, int i, int j, Set<String> seen) {
        seen.add(i + "," + j);
        robot.clean();
        for (int k = 0; k < 4; k++) {
            int newD = (d + k) % 4;
            int x = i + dirs[newD][0];
            int y = j + dirs[newD][1];
            if (!seen.contains(x + "," + y) && robot.move()) {
                dfs(robot, newD, x, y, seen);
                back(robot);
            }
            robot.turnRight();;
        }
    }
    private void back(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}

