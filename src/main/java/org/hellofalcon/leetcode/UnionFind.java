package org.hellofalcon.leetcode;

import org.hellofalcon.leetcode.utils.ArrayUtils;

/**
 * @author - chugang.cg
 * @create - 2019/2/12
 */
public class UnionFind {

    int n;
    int[] v;
    int[] size;

    UnionFind(int n) {
        this.n = n;
        this.v = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = i;
            size[i] = 1;
        }
    }

    int[] getV() {
        return v;
    }

    /**
     * find the subtree root
     * @param p
     * @return
     */
    int find(int p) {
        while (p != v[p]) p = v[p];
        return p;
    }

    /**
     * test whether the two node is in the same tree
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q) {
        if (find(p) == find(q)) {
            return true;
        } else {
            return false;
        }
    }

    void union(int p, int q) {
        if (p == q) {
            return;
        }
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) return;

        if (size[pRoot] >= size[qRoot]) {
            v[qRoot] = pRoot;
            size[pRoot] +=  + size[qRoot];
        } else {
            v[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        n--;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);

        int[][] edges = new int[][]{
                {4,3},
                {3,8},
                {6,5},
                {9,4},
                {2,1},
                {8,9},
                {5,0},
                {7,2},
                {6,1},
                {1,0},
                {6,7},
        };

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (uf.connected(edge[0], edge[1])) {
                System.out.println(edge[0] + ", " + edge[1] + " skiped");
                continue;
            }
            uf.union(edge[0], edge[1]);
        }

        ArrayUtils.printArrayWithIdx(uf.getV());
    }
}
