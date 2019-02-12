package org.hellofalcon.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * An MST solution based on UnionFind
 * @author - chugang.cg
 * @create - 2019/2/13
 */
public class MST {

    private List<int[]> mst;

    MST(int v, int[][] edges) {
        mst = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(edges.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < edges.length; i++) {
            pq.add(edges[i]);
        }

        UnionFind uf = new UnionFind(v);

        while (!pq.isEmpty() && mst.size() < v - 1) {
            int[] edge = pq.poll();
            int f = edge[0];
            int t = edge[1];
            if(uf.connected(f, t)) continue;
            uf.union(f, t);
            mst.add(edge);
        }
    }

    List<int[]> edges() {
        return mst;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {4, 5, 35},
                {4, 7, 37},
                {5, 7, 28},
                {0, 7, 16},
                {1, 5, 32},
                {0, 4, 38},
                {2, 3, 17},
                {1, 7, 19},
                {0, 2, 26},
                {1, 2, 36},
                {1, 3, 29},
                {2, 7, 34},
                {6, 2, 40},
                {3, 6, 52},
                {6, 0, 58},
                {6, 4, 93},
        };

        MST mst = new MST(8, edges);
        List<int[]> edges1 = mst.edges();
        printList(edges1);
    }

    public static void printList(List<int[]> list) {
        if (list == null) {
            return;
        }
        System.out.print("[ ");
        for(int i = 0; i < list.size(); i ++) {
            int[] l = list.get(i);
            System.out.print(l[0] + " " + l[1] + " " + l[2]);
            System.out.println();
        }
        System.out.println(" ]");
    }

}
