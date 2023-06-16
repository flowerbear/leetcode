package com.orlando.java.self001.from1601to1650;

import com.orlando.java.common.BSTNode;

public class Solution1650 {

    public BSTNode lowestCommonAncestor(BSTNode p, BSTNode q) {
        BSTNode a = p, b = q;
        while (a != b) {
            if (a == null) a = q;
            else a = a.parent;
            if (b == null) b = p;
            else b = b.parent;
        }
        return a;
    }
}
