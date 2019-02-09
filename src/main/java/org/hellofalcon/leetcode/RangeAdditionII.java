package org.hellofalcon.leetcode;

/**
 *
 * 598. Range Addition II
 *
 * @author - chugang.cg
 * @create - 2019/2/10
 */
public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        for (int i = 0; i < ops.length; i++) {
            m = Math.min(m, ops[i][0]);
            n = Math.min(n, ops[i][1]);
        }

        return m * n;
    }
}
