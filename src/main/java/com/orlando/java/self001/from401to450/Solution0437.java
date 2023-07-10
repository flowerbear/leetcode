package com.orlando.java.self001.from401to450;

import com.orlando.java.common.TreeNode;

import java.util.HashMap;

public class Solution0437 {

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> preSum = new HashMap<>();
        preSum.put(0L, 1);
        return helper(root, 0L, targetSum, preSum);
    }

    private int helper(TreeNode root, long currSum, int target, HashMap<Long, Integer> preSum) {

        if (root == null) return 0;

        currSum += root.val;
        //if (preSum.containsKey(currSum - target)) count += preSum.get(currSum - target);
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);

        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}

