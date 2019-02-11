package org.hellofalcon.leetcode.common;

import org.hellofalcon.leetcode.utils.ArrayUtils;

/**
 * @author - chugang.cg
 * @create - 2019/2/10
 */
public class MaxHeap<Key extends Comparable<Key>> {

    private Key[] pq;

    private int n = 0;

    public MaxHeap(int maxCapacity) {
        this.pq = (Key[]) new Comparable[maxCapacity + 1]; // index start from 1
    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public int size() {
        return n;
    }

    public void insert(Key v) {
        if (n == 0) {
            pq[++n] = v;
        } else {
            pq[++n] = v;
            swim(n);
        }
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, n);
        n--;
        pq[n + 1] = null;
        sink(1);
        return max;
    }

    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2; // get the parent
        }
    }

    public void print() {
        ArrayUtils.printArray(pq);
    }

    public void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k; // get the child
            if (j < n && less(j, j + 1)) j++; // chose a greater one to exchange
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(5);

        maxHeap.insert(1);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(7);
        maxHeap.insert(3);

        maxHeap.print();

        Integer m1 = maxHeap.delMax();
        System.out.println("delMax : " + m1);
        maxHeap.print();

        Integer m2 = maxHeap.delMax();
        System.out.println("delMax : " + m2);
        maxHeap.print();
    }
}
