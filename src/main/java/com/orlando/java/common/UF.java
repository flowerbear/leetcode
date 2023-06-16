package com.orlando.java.common;

public class UF {

    private int count;
    private int[] parent;

    //private int[] size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        //size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            //size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        //if (size[rootP] > size[rootQ]) {
        parent[rootQ] = rootP;
        //    size[rootP] += size[rootQ];
        //} else {
         //   parent[rootP] = rootQ;
        //    size[rootQ] += size[rootP];
        //}
        count--;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int count() { return count; }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public static void main(String[] args) {
        UF temp = new UF(10);
        temp.union(0, 1);;
        temp.union(0, 6);
        temp.union(0, 3);
        temp.union(2, 5);
        temp.union(1, 5);
    }
}
