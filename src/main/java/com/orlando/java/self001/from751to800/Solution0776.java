package com.orlando.java.self001.from751to800;
import com.orlando.java.common.TreeNode;

public class Solution0776 {
    public TreeNode[] splitBST(TreeNode root, int V) {
       if (root == null) return new TreeNode[]{null, null};
       else if (root.val <= V) {
           TreeNode[] result = splitBST(root.right, V);
           root.right = result[0];
           return new TreeNode[]{root, result[1]};
        } else {
           TreeNode[] result = splitBST(root.left, V);
           root.left = result[1];
           return new TreeNode[]{result[0], root};
       }
    }
}

