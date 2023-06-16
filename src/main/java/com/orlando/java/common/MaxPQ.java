package com.orlando.java.common;

public class MaxPQ <Key extends Comparable<Key>> {

    int parent(int root) {
        return root / 2;
    }

    int left(int root) {
        return root * 2;
    }

    int right(int root) {
        return root * 2 + 1;
    }

    private Key[] pq;
    private int size;
    public MaxPQ(int cap) {
        this.pq = (Key[]) new Comparable[cap + 1];
    }

    public Key max() {
        return pq[1];
    }

    public void insert(Key e) {
        this.size++;
        pq[size] = e;
        swin(this.size);
    }

    public Key delMax() {
        Key result = pq[1];
        swap(1, size);
        pq[size] = null;
        size--;
        sink(1);
        return result;
    }

    private void swin(int x) {
        while (x > 1 && less(parent(x), x)) {
            swap(x, parent(x));
            x = parent(x);
        }
    }

    private void sink(int x) {
        while (left(x) <= size) {
            int max = left(x);
            if (right(x) <= size && less(max, right(x))) max = right(x);
            if (less(max, x)) break;
            swap(max, x);
            x = max;
        }
    }

    private void swap(int x, int y) {
        Key temp = pq[x];
        pq[x] = pq[y];
        pq[y] = temp;
    }

    private boolean less(int x, int y) {
        return pq[x].compareTo(pq[y]) < 0;
    }
}
