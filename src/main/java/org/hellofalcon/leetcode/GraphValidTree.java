package org.hellofalcon.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 261. Graph Valid Tree
 *
 * @author - chugang.cg
 * @create - 2019/2/11
 */
public class GraphValidTree {

    /**
     *
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree(int n, int[][] edges) {

        // use this map to count the number of parents of a node
        Map<Integer, Integer> visit = new HashMap<>();

        for (int[] edge : edges) {
            if (edge[0] == edge[1]) {
                continue;
            }

            // standerlise input
            int start = Math.min(edge[0], edge[1]);
            int end = Math.max(edge[0], edge[1]);

            // handler the initiating situation
            visit.putIfAbsent(start, 0);

            visit.put(end, visit.getOrDefault(end, 0) + 1);

            // to check whether this loop should ended
            if (visit.get(end) > 1) {
                return false;
            }
        }

        // check if there are more than one roots
        int rootCount = 0;
        for (Integer integer : visit.keySet()) {
            if (visit.get(integer) == 0) {
                rootCount += 1;
            }
        }

        if (rootCount > 1) {
            return false;
        }

        if (n > 1 && n - visit.size() >= 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        GraphValidTree gvt = new GraphValidTree();

        int[][] in1 = new int[][]{{0,1}, {0,2}, {0,3}, {1,4}};

        System.out.println(gvt.validTree(5, in1));

        int[][] in2 = new int[][]{{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};

        System.out.println(gvt.validTree(5, in2));

        int[][] in3 = new int[][]{{0,1}, {2,3}}; // false

        System.out.println(gvt.validTree(4, in3));

        int[][] in4 = new int[][]{{0,1}}; // false

        System.out.println(gvt.validTree(3, in4));

        int[][] in5 = new int[][]{}; // false

        System.out.println(gvt.validTree(3, in5));

        int[][] in6 = new int[][]{}; // true

        System.out.println(gvt.validTree(1, in6));

        int[][] in7 = new int[][]{{2, 0}, {2, 1}}; // true

        System.out.println(gvt.validTree(3, in7));
    }

}
