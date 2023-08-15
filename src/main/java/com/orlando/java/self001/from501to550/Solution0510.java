package com.orlando.java.self001.from501to550;

import com.orlando.java.common.Node;

public class Solution0510 {

    public Node inorderSuccessor(Node node) {
        if (node.right == null) {
            while (node.parent != null && node.parent.left != node) node = node.parent;
            return node.parent;
        }
        node = node.right;
        while (node.left != null) node = node.left;
        return node;
    }
}

